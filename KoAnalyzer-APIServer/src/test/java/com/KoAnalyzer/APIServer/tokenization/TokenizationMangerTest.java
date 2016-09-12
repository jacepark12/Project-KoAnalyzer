package com.KoAnalyzer.APIServer.tokenization;

import com.KoAnalyzer.APIServer.Phrase;
import com.KoAnalyzer.APIServer.extraction.ExtractionManager;
import com.KoAnalyzer.APIServer.extraction.ExtractionText;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by parkjaesung on 2016. 9. 12..
 */
public class TokenizationMangerTest {

    public static void main(String[] args){
        String inputText = "한국어를 처리하는 예시입니다ㅋㅋ";

        TokenizationText tokenizationText = new TokenizationText(inputText);

        TokenizationManger tokenizationManger = TokenizationManger.getInstance();

        System.out.println("result : "  + tokenizationManger.tokenizeText(tokenizationText).getPhrases() ) ;

        ArrayList<Phrase> phraseArrayList = (ArrayList<Phrase>) tokenizationManger.tokenizeText(tokenizationText).getPhrases();

        System.out.println(phraseArrayList);
    }

    @Test
    public void testTokenizeText() throws Exception {

    }
}