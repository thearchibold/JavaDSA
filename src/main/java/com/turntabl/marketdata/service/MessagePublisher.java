package com.turntabl.marketdata.service;

import com.turntabl.marketdata.dto.OrderBookDto;

import java.util.List;

@FunctionalInterface
public interface MessagePublisher {
    void publish(final List<OrderBookDto> message);
}
