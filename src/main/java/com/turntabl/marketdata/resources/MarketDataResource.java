package com.turntabl.marketdata.resources;

import com.turntabl.marketdata.dto.OrderBookDto;
import com.turntabl.marketdata.service.MarketDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@RequiredArgsConstructor
public class MarketDataResource {

    private final MarketDataService marketDataService;

//    @RequestMapping(value="/market-data", method= RequestMethod.POST) same as below
    @PostMapping("/market-data")
    ResponseEntity<Object> getMarketData(@RequestBody ArrayList<OrderBookDto> orderBooks){
        log.info("order books: {}" ,orderBooks);
        return ResponseEntity.ok("success!!");
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
    ResponseEntity<?> subscribe() {
       return new ResponseEntity<>("Mickey D Luffy", HttpStatus.ACCEPTED);
    }

}
