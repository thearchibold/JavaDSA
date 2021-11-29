package com.turntabl.marketdata.service;

@FunctionalInterface
public interface MessagePublisher {
    void publish(final String message);
}
