package com.KoAnalyzer.APIServer.tokenization;

import com.KoAnalyzer.APIServer.Phrase;

import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 10..
 */
public class TokenizationText {

    private final String originalText;
    private List<Phrase> phrases;

    public TokenizationText(String originalText) {
        this.originalText = originalText;
    }

    public String getOriginalText(){
        return originalText;
    }

    public List<Phrase> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<Phrase> phrases) {
        this.phrases = phrases;
    }
}
