package com.turntabl.marketdata.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.turntabl.marketdata.dto.ErrorMessage;
import com.turntabl.marketdata.dto.OrderBookDto;
import com.turntabl.marketdata.exceptions.AlreadySubscribedException;
import com.turntabl.marketdata.exceptions.EntityNotFoundException;
import com.turntabl.marketdata.service.MarketDataService;
import com.turntabl.marketdata.service.impl.RedisMessagePublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@RequiredArgsConstructor
public class MarketDataResource {
    @Value("${market-data.variables.redis.topic}")
    private  String topic;
    private final MarketDataService marketDataService;
    private final RedisMessagePublisher redisMessagePublisher;

    @PostMapping("/market-data")
    ResponseEntity<Object> getMarketData(@RequestBody ArrayList<OrderBookDto> orderBooks){
        log.info("order books: {}" ,orderBooks);
        return ResponseEntity.ok("success!!");
    }
    @PostMapping("/callback/webhook")
    ResponseEntity<Object> onMarketDataSubscribe(@RequestBody ArrayList<OrderBookDto> orderBooks){
        log.info("order books: {}" ,orderBooks);
        return ResponseEntity.ok("success!!");
    }
    @PostMapping("/test")
    public void test(@RequestBody String body) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        OrderBookDto orderBookDto = new OrderBookDto();
        OrderBookDto orderBookDto2 = new OrderBookDto();
        orderBookDto.setAskPrice(50.5f);
        orderBookDto2.setAskPrice(80.5f);
        orderBookDto.setBidPrice(50.5f);
        orderBookDto2.setBidPrice(80.5f);
        orderBookDto.setTicker("aapl");
        orderBookDto2.setTicker("msft");
        orderBookDto.setBuyLimit(100);
        orderBookDto.setBuyLimit(200);
        String arrayToJson = null;
        
        try {
            arrayToJson = objectMapper.writeValueAsString(List.of(orderBookDto, orderBookDto2));
            redisMessagePublisher.publish(arrayToJson);
        } catch (JsonProcessingException ex) {
            System.out.println("Error processing data");
        }

    }

    @PostMapping("/callback2/webhook")
    public void onSecondMarketDataSubscribe(@RequestBody String body) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        OrderBookDto orderBookDto = new OrderBookDto();
        OrderBookDto orderBookDto2 = new OrderBookDto();
        orderBookDto.setAskPrice(10f);
        orderBookDto2.setAskPrice(102f);
        orderBookDto.setBidPrice(400f);
        orderBookDto2.setBidPrice(903f);
        orderBookDto.setTicker("mxn");
        orderBookDto2.setTicker("dluffy");
        orderBookDto.setBuyLimit(9875);
        orderBookDto.setBuyLimit(10000);
        String arrayToJson = null;

        try {
            arrayToJson = objectMapper.writeValueAsString(List.of(orderBookDto, orderBookDto2));
            redisMessagePublisher.publish2(arrayToJson);
        } catch (JsonProcessingException ex) {
            System.out.println("Error processing data");
        }

    }


    @GetMapping("/md")
    ResponseEntity<?> getOrderBooks() {
        log.info("prntin top {}",topic);
        return new ResponseEntity<>(marketDataService.getOrderBooks(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/md/subscription")
    ResponseEntity<?> getSubscriptions() {
      return new ResponseEntity<>(marketDataService.getSubscriptions(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/md/subscription")
    ResponseEntity<?> subscribe(UriComponentsBuilder uriBuilder) {
        try {
            marketDataService.subscribe();
        } catch (AlreadySubscribedException ex) {
            var errorResponse = ErrorMessage.builder()
                    .message(ex.getMessage())
                    .httpStatus(HttpStatus.CONFLICT)
                    .build();
          return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/md/subscription")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unsubscribe() throws EntityNotFoundException {
        var unsubscribeSuccessful = this.marketDataService.unsubscribe();
        if(!unsubscribeSuccessful) {
            throw  new EntityNotFoundException("No subscription exists with that callback") ;
        }

    }

    @PutMapping("/md/subscription")
    public void mutateSubscriptionCallback() {

    }
    


}
