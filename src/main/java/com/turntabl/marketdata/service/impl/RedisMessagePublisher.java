package com.turntabl.marketdata.service.impl;

import com.turntabl.marketdata.service.MessagePublisher;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RedisMessagePublisher implements MessagePublisher {
    private final   RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic topic;
//    private final Channe topic;

    @Override
    public void publish(String message) {
       redisTemplate.convertAndSend(topic.getTopic(), message);
    }

    public void publish2(String message) {
        redisTemplate.convertAndSend("pubsub:market-data-ex2", message);
    }
}
