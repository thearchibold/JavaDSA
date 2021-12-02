package com.turntabl.marketdata.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.turntabl.marketdata.dto.OrderBookDto;
import com.turntabl.marketdata.service.MessagePublisher;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class RedisMessagePublisher implements MessagePublisher {
    private final   RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic topic;
//    private final Channel topic;

    @Override
    public void publish(List<OrderBookDto> message) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String arrayToJson = null;
        try {
            log.info("===> Serializing list of order books from exchange one ===>");
            arrayToJson = objectMapper.writeValueAsString(message);
            redisTemplate.convertAndSend(topic.getTopic(), arrayToJson);
            log.info("===> Exchange one publishing order books on channel: {}===>", topic.getTopic());
        } catch (JsonProcessingException ex) {
            log.info("JsonProcessingException occured while serializing order books from exchange one: channel {} ==>", topic.getTopic());
        }



    }

    public void publish2(String message) {
        redisTemplate.convertAndSend("pubsub:market-data-ex2", message);
    }
}
