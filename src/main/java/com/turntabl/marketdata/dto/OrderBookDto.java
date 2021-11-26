package com.turntabl.marketdata.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderBookDto {
    @JsonProperty("TICKER")
    private String ticker;

    @JsonProperty("SELL_LIMIT")
    private int sellLimit;

    @JsonProperty("BUY_LIMIT")
    private int buyLimit;

    @JsonProperty("MAX_PRICE_SHIFT")
    private float maxPriceShift;

    @JsonProperty("BID_PRICE")
    private float bidPrice;

    @JsonProperty("ASK_PRICE")
    private float askPrice;

    @JsonProperty("LAST_TRADED_PRICE")
    private float lastTradedPrice;


}
