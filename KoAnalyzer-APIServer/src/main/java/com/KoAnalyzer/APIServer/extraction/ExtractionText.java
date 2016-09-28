package com.KoAnalyzer.APIServer.extraction;

import com.KoAnalyzer.APIServer.Phrase;
import com.twitter.penguin.korean.phrase_extractor.KoreanPhraseExtractor;

import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 6..
 */

public class ExtractionText {

    private final String originalText;
    private final String task;
    private List<Phrase> phrases;

    public ExtractionText(String originalText, String task) {
        this.originalText = originalText;
        this.task = task;
    }

    public String getOriginalText() {
        return originalText;
    }

    public List<Phrase> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<Phrase> phrases) {
        this.phrases = phrases;
    }

    public String getTask() {
        return task;
    }
}

