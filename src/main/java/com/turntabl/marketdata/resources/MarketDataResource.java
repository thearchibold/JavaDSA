package com.turntabl.marketdata.resources;

import com.turntabl.marketdata.dto.ErrorMessage;
import com.turntabl.marketdata.dto.OrderBookDto;
import com.turntabl.marketdata.exceptions.AlreadySubscribedException;
import com.turntabl.marketdata.exceptions.EntityNotFoundException;
import com.turntabl.marketdata.service.MarketDataService;
import com.turntabl.marketdata.service.impl.RedisMessagePublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        redisMessagePublisher.publish(body);
        log.info("Webhok call back from git {}", body);
    }



    @GetMapping("/md")
    ResponseEntity<?> getOrderBooks() {
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
