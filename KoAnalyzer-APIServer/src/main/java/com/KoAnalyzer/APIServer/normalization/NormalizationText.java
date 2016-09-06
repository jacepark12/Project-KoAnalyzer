package com.KoAnalyzer.APIServer.normalization;

/**
 * Created by parkjaesung on 2016. 9. 6..
 */
public class NormalizationText {

    private final String originalText;
    private String normalizatedText;

    public NormalizationText(String originalText) {
        this.originalText = originalText;
    }

    public String getOriginalText() {
        return originalText;
    }

    public String getNormalizatedText() {
        return normalizatedText;
    }

    public void setNormalizatedText(String normalizatedText) {
        this.normalizatedText = normalizatedText;
    }
}
