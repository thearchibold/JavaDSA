package com.turntabl.marketdata.service.impl;

import com.turntabl.marketdata.dto.OrderBookDto;
import com.turntabl.marketdata.service.MarketDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Service
public class MarketDataServiceImpl implements MarketDataService {
    @Autowired
    private  RestTemplate restTemplate;

    @Value("${market-data.variables.exchange-url.one}")
    private String exchange1Url;

    @Value("${market-data.variables.callback}")
    private String callback;

    @Override
    public List<OrderBookDto> getOrderBooks() {
//        return restTemplate
//                .getForEntity(exchange1Url, List<OrderBookDto>.class).getBody();
        return restTemplate.exchange(exchange1Url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<OrderBookDto>>(){}).getBody();

    }

    @Override
    public List<String> getSubscriptions() {
        return restTemplate.exchange(exchange1Url + "/subscription", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<String>>() { }).getBody();
    }

    @Override
    public void subscribe() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        HttpEntity<?> httpEntity = new HttpEntity<>(callback, httpHeaders);
        restTemplate.exchange(exchange1Url + "/subscription", HttpMethod.POST, httpEntity, String.class);
    }
}
