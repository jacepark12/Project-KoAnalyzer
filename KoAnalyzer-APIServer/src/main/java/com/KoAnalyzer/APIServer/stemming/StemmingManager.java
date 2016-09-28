package com.KoAnalyzer.APIServer.stemming;

import com.KoAnalyzer.APIServer.NLPManager.TokenManagerImpl;
import com.KoAnalyzer.APIServer.NLPManager.TokenMangerInterface;
import com.KoAnalyzer.APIServer.Phrase;
import com.sun.javafx.fxml.expression.Expression;
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
public class StemmingManager extends TokenManagerImpl {

    private static StemmingManager instance = new StemmingManager();

    private StemmingManager(){

    }

    public static StemmingManager getInstance(){
        return instance;
    }

    public StemmingText stemText(StemmingText stemmingText){
        Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(stemmingText.getOriginalText());

        stemmingText.setPhrases(convertTokens(TwitterKoreanProcessorJava.stem(tokens), stemmingText.getTask()));
        return stemmingText;
    }

}
