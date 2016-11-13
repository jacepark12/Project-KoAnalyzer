package com.KoAnalyzer.APIServer.extraction;

import com.KoAnalyzer.APIServer.Phrase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by parkjaesung on 2016. 9. 6..
 */
public class ExtractionManagerTest {

    public static void main(String[] args){
        String inputText = "한국어를 처리하는 예시입니다ㅋㅋ";
        String exepectedResult = "";

        ExtractionText extractionText = new ExtractionText(inputText, "Task");

        ExtractionManager extractionManager = ExtractionManager.getInstance();

        System.out.println("result : "  +extractionManager.extractText(extractionText).getPhrases() ) ;

        ArrayList<Phrase> phraseArrayList = (ArrayList<Phrase>) extractionManager.extractText(extractionText).getPhrases();
    }

    @Test
    public void testExtractText() throws Exception {
        String inputText = "한국어를 처리하는 예시입니다ㅋㅋ";
        String exepectedResult = "";

        ExtractionText extractionText = new ExtractionText(inputText, "Task");

        ExtractionManager extractionManager = ExtractionManager.getInstance();
        System.out.println("result : "  +extractionManager.extractText(extractionText).getPhrases() ) ;

    }
}