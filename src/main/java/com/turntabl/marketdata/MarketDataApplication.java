package com.turntabl.marketdata;

import com.turntabl.marketdata.service.MessageListener;
import com.turntabl.marketdata.service.impl.RedisMessageSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Slf4j
public class MarketDataApplication {
    @Value("${market-data.test}")
    private static String test;
    public static void main(String[] args) {
        SpringApplication.run(MarketDataApplication.class, args);
        log.info("This is testing ENVS {}", test);
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
