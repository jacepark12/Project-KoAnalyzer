package com.analyze.ko.framework.server.servlet.rest;

import com.twitter.penguin.korean.KoreanTokenJava;
import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import scala.collection.Seq;
import scala.collection.convert.WrapAsJava$;

import javax.annotation.Generated;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by parkjaesung on 2016. 7. 23..
 */
@Path("/analyze")
public class AnalyzeRestAPI {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/document/q={document}")
    public String analyzeDoucment(@PathParam("document")final String document){
        System.out.println("analyze document");

        return "Document analyze";
    }

    @GET
    @Path("/sentence/q={sentence}")
    @Produces("application/json"+ ";charset=utf-8")
    public String analyzeSentence(@PathParam("sentence")final String sentence) throws JSONException {

        JSONObject resultJSON = new JSONObject();
        JSONArray tokensJSON = new JSONArray();

        //Analyze pos
        //SearchCorpusData object for searching word in corpus data
        Seq<KoreanTokenizer.KoreanToken> scalaTokens = getKoreanTokensFromText(sentence);

        List<KoreanTokenJava> tokens =  TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(scalaTokens);
        // [한국어(Noun: 0, 3), 를(Josa: 3, 1),  (Space: 4, 1), 처리(Noun: 5, 2), 하는(Verb: 7, 2),  (Space: 9, 1), 예시(Noun: 10, 2), 입니(Adjective: 12, 2), 다(Eomi: 14, 1), ㅋㅋ(KoreanParticle: 15, 2),  (Space: 17, 1), #한국어(Hashtag: 18, 4)]

        for (KoreanTokenJava token: tokens) {
            JSONObject tokenJSON = new JSONObject();

            try {
                tokenJSON.put(token.getText(),token.getPos());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            tokensJSON.put(tokenJSON);
        }

        resultJSON.put("result", tokensJSON);

        return resultJSON.toString();
    }

    private List<KoreanTokenizer.KoreanToken> convertToList(scala.collection.Seq<KoreanTokenizer.KoreanToken> seq) {
        return WrapAsJava$.MODULE$.seqAsJavaList(seq);
    }

    private Seq<KoreanTokenizer.KoreanToken> getKoreanTokensFromText(String text){
        // Normalize
        CharSequence normalized = TwitterKoreanProcessorJava.normalize(text);
        System.out.println(normalized);

        Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(normalized);

        return tokens;
    }
}
