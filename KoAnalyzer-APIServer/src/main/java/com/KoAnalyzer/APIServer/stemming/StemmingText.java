package com.KoAnalyzer.APIServer.stemming;

import com.KoAnalyzer.APIServer.Phrase;
import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 9..
 */
public class StemmingText {

    private final String originalText;
    private final String task;
    private List<Phrase> phrases;

    public StemmingText(String originalText, String task) {
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
