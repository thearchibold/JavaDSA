package com.turntabl.marketdata.resources;

import com.turntabl.marketdata.dto.OrderBookDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/webhook")
@Slf4j
public class MarketDataResource {


//    @RequestMapping(value="/market-data", method= RequestMethod.POST) same as below
    @PostMapping("/market-data")
    ResponseEntity<Object> getMarketData(@RequestBody ArrayList<OrderBookDto> orderBooks){
        log.info("order books: {}" ,orderBooks);
        return ResponseEntity.ok("success!!");
    }
}
