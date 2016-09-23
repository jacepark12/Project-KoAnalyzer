package com.KoAnalyzer.APIServer.extraction;

import com.KoAnalyzer.APIServer.PhraseService;
import com.KoAnalyzer.APIServer.PostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST,
    consumes = "application/json")
    public ExtractionText postExtractionText(@RequestBody PostRequest requestBody){
        System.out.println("Request Body : "+ requestBody);

        ExtractionText extractionText = new ExtractionText(requestBody.getText());

        ExtractionText extractedText = extractionManager.extractText(extractionText);

        phraseService.savePhrases(extractedText.getPhrases());

        return extractedText;
    }

}
