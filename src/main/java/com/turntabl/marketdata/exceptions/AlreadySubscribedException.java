package com.turntabl.marketdata.exceptions;

public class AlreadySubscribedException extends Exception{
    public AlreadySubscribedException(String callback) {
        super("You have already subscribed with this callback: " + callback);
    }
}
