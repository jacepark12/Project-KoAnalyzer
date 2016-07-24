package com.analyze.ko.framework.korean.DataClass;

import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;
import org.json.JSONObject;
import scala.collection.Seq;
import scala.collection.convert.WrapAsJava$;

import java.util.List;

/**
 * Created by parkjaesung on 2016. 7. 23..
 */
public class Sentence {

    private String textData;
    private int textLength;

    //constructor
    public Sentence(){

    }

    public String getTextData() {
        return textData;
    }

    public void setTextData(String textData) {
        this.textData = textData;
    }

    public int getTextLength() {
        return textLength;
    }

    public void setTextLength(int textLength) {
        this.textLength = textLength;
    }

    public JSONObject analyzeSentence(){
        JSONObject result = new JSONObject();

        //SearchCorpusData object for searching word in corpus data
        Seq<KoreanTokenizer.KoreanToken> tokens = getKoreanTokensFromText(this.textData);

        System.out.println(TwitterKoreanProcessorJava.tokensToJavaStringList(tokens));
        // [한국어, 를, 처리, 하는, 예시, 입니, 다, ㅋㅋ, #한국어]
        System.out.println(TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(tokens));
        // [한국어(Noun: 0, 3), 를(Josa: 3, 1),  (Space: 4, 1), 처리(Noun: 5, 2), 하는(Verb: 7, 2),  (Space: 9, 1), 예시(Noun: 10, 2), 입니(Adjective: 12, 2), 다(Eomi: 14, 1), ㅋㅋ(KoreanParticle: 15, 2),  (Space: 17, 1), #한국어(Hashtag: 18, 4)]

        List<KoreanTokenizer.KoreanToken> textTokens = convertToList(tokens);

        for (KoreanTokenizer.KoreanToken textToken: textTokens) {
          //  textToken.
        }

        return result;
    }

    private Seq<KoreanTokenizer.KoreanToken> getKoreanTokensFromText(String text){
        // Normalize
        CharSequence normalized = TwitterKoreanProcessorJava.normalize(text);
        System.out.println(normalized);

        Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(normalized);

        return tokens;
    }
    private List<KoreanTokenizer.KoreanToken> convertToList(scala.collection.Seq<KoreanTokenizer.KoreanToken> seq) {
        return WrapAsJava$.MODULE$.seqAsJavaList(seq);
    }


}
