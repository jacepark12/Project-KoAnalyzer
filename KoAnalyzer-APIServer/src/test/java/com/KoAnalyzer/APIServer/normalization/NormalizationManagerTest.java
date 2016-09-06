package com.KoAnalyzer.APIServer.normalization;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by parkjaesung on 2016. 9. 6..
 */
public class NormalizationManagerTest {

    @Test
    public void testNormalizeText() throws Exception {
        String input = "한국어를 처리하는 예시입니닼ㅋㅋㅋㅋㅋ";
        String expectedResult = "한국어를 처리하는 예시입니다ㅋㅋ";

        NormalizationText normalizationText = new NormalizationText(input);

        NormalizationManager normalizationManager = NormalizationManager.getInstance();

        assertEquals(normalizationManager.normalizeText(normalizationText).getNormalizatedText(), expectedResult);
    }
}