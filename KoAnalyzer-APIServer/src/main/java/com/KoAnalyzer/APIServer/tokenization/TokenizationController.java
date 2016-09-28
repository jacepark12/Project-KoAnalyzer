package com.KoAnalyzer.APIServer.tokenization;

import com.KoAnalyzer.APIServer.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by parkjaesung on 2016. 9. 6..
 */

@RequestMapping("/tokenization")
@RestController
public class TokenizationController {

    @Autowired
    TokenizationManger tokenizationManger;

    @Autowired
    PhraseService phraseService;

    @RequestMapping(value = "/{text}", method = RequestMethod.GET)
    public TokenizationText getTokenizedText(@PathVariable("text")String originalText){
        TokenizationText tokenizationText = new TokenizationText(originalText, "default");

        return tokenizationManger.tokenizeText(tokenizationText);
    }

    @RequestMapping(value = "/{text}", method = RequestMethod.POST)
    public TokenizationText postTokenizedText(@PathVariable("text")String originalText){

        //TODO Set task by POST Body
        TokenizationText tokenizationText = new TokenizationText(originalText, "default");

        TokenizationText tokenizedText = tokenizationManger.tokenizeText(tokenizationText);

        phraseService.savePhrases(tokenizedText.getPhrases());

        return tokenizedText;
    }
}
