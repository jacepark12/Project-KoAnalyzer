package com.KoAnalyzer.APIServer.tokenization;

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

    @RequestMapping(value = "/{text}", method = RequestMethod.GET)
    public TokenizationText getTokenizedText(@PathVariable("text")String originalText){
        TokenizationText tokenizationText = new TokenizationText(originalText);

        return tokenizationManger.tokenizeText(tokenizationText);
    }
}
