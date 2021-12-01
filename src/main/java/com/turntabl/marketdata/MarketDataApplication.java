package com.turntabl.marketdata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@Slf4j
@SpringBootApplication
public class MarketDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketDataApplication.class, args);

        var host = System.getenv("REDIS_HOST");
        int port= Integer.parseInt(System.getenv("REDIS_PORT"));
        String password = System.getenv("REDIS_PASSWORD");
        log.info("Rei details {} in main===", host);
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
