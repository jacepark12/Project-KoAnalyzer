package com.KoAnalyzer.APIServer.extraction;

import com.twitter.penguin.korean.phrase_extractor.KoreanPhraseExtractor;

import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 6..
 */

public class ExtractionText {

    private final String originalText;
    private List<KoreanPhraseExtractor.KoreanPhrase> phrases;

    public ExtractionText(String originalText) {
        this.originalText = originalText;
    }

    public String getOriginalText() {
        return originalText;
    }

    public List<KoreanPhraseExtractor.KoreanPhrase> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<KoreanPhraseExtractor.KoreanPhrase> phrases) {
        this.phrases = phrases;
    }
}
