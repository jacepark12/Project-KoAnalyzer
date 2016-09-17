package com.KoAnalyzer.APIServer;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by parkjaesung on 2016. 8. 31..
 */

@Configuration
@EnableJpaRepositories
@EnableAutoConfiguration
@ComponentScan
@EntityScan
@PropertySource("config.properties")
public class APIServerLauncher {

    public static void main(String[] args){
        org.springframework.boot.SpringApplication.run(APIServerLauncher.class);
    }
}
