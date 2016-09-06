package com.KoAnalyzer.APIServer.normalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by parkjaesung on 2016. 9. 6..
 */
@RequestMapping("/normalization")
@RestController
public class NormalizationController{

    @Autowired
    NormalizationManager normalizationManager;

    @RequestMapping(value = "/{text}", method = RequestMethod.GET)
    public NormalizationText getNormalizeText(@PathVariable("text")String originalText){
        NormalizationText normalizationText = new NormalizationText(originalText);

        return normalizationManager.normalizeText(normalizationText);
    }
}
