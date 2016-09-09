package com.KoAnalyzer.APIServer.stemming;

import com.KoAnalyzer.APIServer.Phrase;
import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;
import org.springframework.stereotype.Service;
import scala.collection.Seq;
import scala.collection.convert.WrapAsJava$;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 9..
 * StemmingManager works with StemmingText class
 */
@Service
public class StemmingManager {

    private static StemmingManager instance = new StemmingManager();

    private StemmingManager(){

    }

    public static StemmingManager getInstance(){
        return instance;
    }

    public StemmingText stemText(StemmingText stemmingText){
        Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(stemmingText.getOriginalText());

        stemmingText.setPhrases(convertTokens(TwitterKoreanProcessorJava.stem(tokens)));
        return stemmingText;
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
