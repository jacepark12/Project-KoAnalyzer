package com.KoAnalyzer.APIServer.normalization;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by parkjaesung on 2016. 9. 6..
 */
@RequestMapping("/normalization")
@RestController
public class NormalizationController{

    @RequestMapping("/{text}")
    public String test(@PathVariable("text")String text){
        System.out.println("Normalization Controller");
        return "input : " + text;
    }
}
