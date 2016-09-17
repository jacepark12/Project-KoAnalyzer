package com.KoAnalyzer.APIServer.stemming;

import com.KoAnalyzer.APIServer.PhraseService;
import com.KoAnalyzer.APIServer.normalization.NormalizationText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by parkjaesung on 2016. 9. 6..
 */
@RequestMapping("/stemming")
@RestController
public class StemmingController {

    @Autowired
    StemmingManager stemmingManager;

    @Autowired
    PhraseService phraseService;

    @RequestMapping(value = "/{text}", method = RequestMethod.GET)
    public StemmingText getStemmedText(@PathVariable("text")String originalText){
        StemmingText stemmingText = new StemmingText(originalText);

        return stemmingManager.stemText(stemmingText);
    }

    @RequestMapping(value = "/{text}", method = RequestMethod.POST)
    public StemmingText potStemmedText(@PathVariable("text")String originalText){
        StemmingText stemmingText = new StemmingText(originalText);

        StemmingText stemmedText = stemmingManager.stemText(stemmingText);

        phraseService.savePhrases(stemmedText.getPhrases());

        return stemmedText;
    }
}
