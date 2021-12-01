package com.turntabl.marketdata;

import com.turntabl.marketdata.service.MessageListener;
import com.turntabl.marketdata.service.impl.RedisMessageSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MarketDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketDataApplication.class, args);
        System.out.println(System.getenv("START"));
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
