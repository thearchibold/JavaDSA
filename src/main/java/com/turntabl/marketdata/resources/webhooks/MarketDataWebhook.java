package com.turntabl.marketdata.resources.webhooks;

import com.turntabl.marketdata.dto.requests.OrderBookDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/webhook")
@Slf4j
public class MarketDataWebhook {


//    @RequestMapping(value="/market-data", method= RequestMethod.POST) same as below
    @PostMapping("/market-data")
    ResponseEntity<Object> getMarketData(@RequestBody ArrayList<OrderBookDto> orderBooks){
        log.info("order books: {}" ,orderBooks);
        return ResponseEntity.ok("success!!");
    }
}
