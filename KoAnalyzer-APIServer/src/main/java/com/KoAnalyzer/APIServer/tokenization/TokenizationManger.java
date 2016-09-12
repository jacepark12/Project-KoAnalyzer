package com.KoAnalyzer.APIServer.tokenization;

import com.KoAnalyzer.APIServer.Phrase;
import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;
import org.springframework.stereotype.Service;
import scala.collection.Seq;
import scala.collection.convert.WrapAsJava$;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 10..
 */
@Service
public class TokenizationManger {

    private static TokenizationManger instance = new TokenizationManger();

    private TokenizationManger(){

    }

    public static TokenizationManger getInstance(){
        return instance;
    }

    public TokenizationText tokenizeText(TokenizationText tokenizationText){
        Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(tokenizationText.getOriginalText());

        tokenizationText.setPhrases(convertTokens(tokens));

        return tokenizationText;
    }

    private ArrayList<Phrase> convertTokens(Seq<KoreanTokenizer.KoreanToken> tokens){
        ArrayList<Phrase> converted = new ArrayList<Phrase>();

        for(KoreanTokenizer.KoreanToken token : convertToList(tokens)){
            Phrase convertedToken = new Phrase();

            convertedToken.setText(token.text());
            convertedToken.setPos(token.pos().toString());
            convertedToken.setOffset(token.offset());
            convertedToken.setLength(token.length());

            converted.add(convertedToken);
        }

        return converted;
    }

    private List<KoreanTokenizer.KoreanToken> convertToList(scala.collection.Seq<KoreanTokenizer.KoreanToken> seq) {
        return WrapAsJava$.MODULE$.seqAsJavaList(seq);
    }

}
