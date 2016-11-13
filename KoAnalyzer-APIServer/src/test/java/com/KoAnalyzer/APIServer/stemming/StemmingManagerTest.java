package com.KoAnalyzer.APIServer.stemming;

import com.KoAnalyzer.APIServer.Phrase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by parkjaesung on 2016. 9. 9..
 */
public class StemmingManagerTest {

    public static void main(String[] args){
        StemmingManager stemmingManager = StemmingManager.getInstance();

        StemmingText stemmingText = new StemmingText("이것이 예시입니닼ㅋ", "task");
        ArrayList<Phrase> stemmed = (ArrayList<Phrase>) stemmingManager.stemText(stemmingText).getPhrases();
    }

    @Test
    public void testStemText() throws Exception {

    }
}