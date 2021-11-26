package com.turntabl.marketdata.service.impl;

import com.turntabl.marketdata.dto.OrderBookDto;
import com.turntabl.marketdata.service.MarketDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MarketDataServiceImpl implements MarketDataService {
    @Autowired
    private  RestTemplate restTemplate;

    @Value("${market-data.variables.exhange-url}")
    private String exchange1Url;

    @Override
    public List<OrderBookDto> getOrderBooks() {

//        restTemplate.exchange(exchange1Url, HttpMethod.GET, )
        return null;
    }
}
