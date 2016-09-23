package com.KoAnalyzer.APIServer.tokenization;

import com.KoAnalyzer.APIServer.NLPManager.TokenManagerImpl;
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
public class TokenizationManger extends TokenManagerImpl{

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

}
