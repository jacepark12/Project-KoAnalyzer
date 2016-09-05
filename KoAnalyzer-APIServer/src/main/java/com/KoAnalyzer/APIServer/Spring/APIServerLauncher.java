package com.KoAnalyzer.APIServer.Spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by parkjaesung on 2016. 8. 31..
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class APIServerLauncher {

    public static void main(String[] args){
        org.springframework.boot.SpringApplication.run(APIServerLauncher.class);
    }
}
