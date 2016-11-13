package com.KoAnalyzer.APIServer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by parkjaesung on 2016. 9. 6..
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public String test(){
        return "index";
    }
}
