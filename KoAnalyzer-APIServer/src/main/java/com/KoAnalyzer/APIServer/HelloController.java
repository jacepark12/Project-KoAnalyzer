package com.KoAnalyzer.APIServer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by parkjaesung on 2016. 9. 6..
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String test(){
        return "hello";
    }
}
