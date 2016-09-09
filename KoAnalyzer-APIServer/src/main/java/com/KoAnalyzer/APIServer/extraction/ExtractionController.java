package com.KoAnalyzer.APIServer.extraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by parkjaesung on 2016. 9. 6..
 */
@RequestMapping("/extraction")
@RestController
public class ExtractionController {

    @Autowired
    ExtractionManager extractionManager;

    @RequestMapping(value = "/{text}", method = RequestMethod.GET)
    public ExtractionText getExtractionText(@PathVariable("text")String originalText){
        ExtractionText extractionText = new ExtractionText(originalText);

        return extractionManager.extractText(extractionText);
    }
}
