package com.KoAnalyzer.APIServer.extraction;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by parkjaesung on 2016. 9. 6..
 */
public class ExtractionManagerTest {

    public static void main(String[] args){
        String inputText = "한국어를 처리하는 예시입니다ㅋㅋ";
        String exepectedResult = "";

        ExtractionText extractionText = new ExtractionText(inputText);

        ExtractionManager extractionManager = ExtractionManager.getInstance();

        System.out.println("result : "  +extractionManager.extractText(extractionText).getPhrases() ) ;
        System.out.println("text : "  +extractionManager.extractText(extractionText).getPhrases().get(0).text() ) ;
        System.out.println("productPrefix : "  +extractionManager.extractText(extractionText).getPhrases().get(0).productPrefix() ) ;
        System.out.println("length : "  +extractionManager.extractText(extractionText).getPhrases().get(0).length() ) ;
        System.out.println("pos : "  +extractionManager.extractText(extractionText).getPhrases().get(0).pos() ) ;
        System.out.println("offset : "  +extractionManager.extractText(extractionText).getPhrases().get(0).offset() ) ;
    }

    @Test
    public void testExtractText() throws Exception {
        String inputText = "한국어를 처리하는 예시입니다ㅋㅋ";
        String exepectedResult = "";

        ExtractionText extractionText = new ExtractionText(inputText);

        ExtractionManager extractionManager = ExtractionManager.getInstance();
        System.out.println("result : "  +extractionManager.extractText(extractionText).getPhrases() ) ;

    }
}