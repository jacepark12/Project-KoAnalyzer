package com.KoAnalyzer.APIServer.normalization;

/**
 * Created by parkjaesung on 2016. 9. 6..
 * Singleton Class
 * NormalizationManager works with NormalizationText class
 * Get input as NormalizationText and return Normalization class
 */
public class NormalizationManager {

    private static NormalizationManager instance = new NormalizationManager();

    private NormalizationManager(){

    }

    public static NormalizationManager getInstance(){
        return instance;
    }

}
