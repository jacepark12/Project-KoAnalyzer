package com.KoAnalyzer.APIServer.normalization;

import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by parkjaesung on 2016. 9. 6..
 * Singleton Class
 * NormalizationManager works with NormalizationText class
 * Get input as NormalizationText and return Normalization class
 */
@Service
public class NormalizationManager {

    private static NormalizationManager instance = new NormalizationManager();

    private NormalizationManager(){

    }

    public static NormalizationManager getInstance(){
        return instance;
    }

    public NormalizationText normalizeText(NormalizationText normalizationText){

        CharSequence normalized = TwitterKoreanProcessorJava.normalize(normalizationText.getOriginalText());
        normalizationText.setNormalizatedText(normalized.toString());

        return normalizationText;
    }

}
