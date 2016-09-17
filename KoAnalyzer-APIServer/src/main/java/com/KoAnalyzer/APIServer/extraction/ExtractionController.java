package com.KoAnalyzer.APIServer.extraction;

import com.KoAnalyzer.APIServer.Phrase;
import com.KoAnalyzer.APIServer.PhraseImpl;
import com.KoAnalyzer.APIServer.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 6..
 */
@RequestMapping("/extraction")
@RestController
public class ExtractionController {

    @Autowired
    ExtractionManager extractionManager;

    @Autowired
    PhraseService phraseService;

    @RequestMapping(value = "/{text}", method = RequestMethod.GET)
    public ExtractionText getExtractionText(@PathVariable("text")String originalText){
        ExtractionText extractionText = new ExtractionText(originalText);
        return extractionManager.extractText(extractionText);
    }

    @RequestMapping(value = "/{text}", method = RequestMethod.POST)
    public ExtractionText postExtractionText(@PathVariable("text")String originalText){
        ExtractionText extractionText = new ExtractionText(originalText);

        ExtractionText extractedText = extractionManager.extractText(extractionText);

        phraseService.savePhrases(extractedText.getPhrases());

        return extractedText;
    }

}
