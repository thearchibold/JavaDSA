package com.turntabl.marketdata.service;

import com.turntabl.marketdata.dto.OrderBookDto;
import com.turntabl.marketdata.exceptions.AlreadySubscribedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public interface MarketDataService {

     List<OrderBookDto> getOrderBooks() ;
     List<String> getSubscriptions();
     void subscribe() throws AlreadySubscribedException;
     Boolean unsubscribe();
     void mutateSubscription();
}
