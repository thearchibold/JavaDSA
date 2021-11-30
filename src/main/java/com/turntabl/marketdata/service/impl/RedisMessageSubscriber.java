package com.turntabl.marketdata.service.impl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.turntabl.marketdata.dto.OrderBookDto;
import lombok.extern.slf4j.Slf4j;
import org.objectweb.asm.TypeReference;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.Message;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class RedisMessageSubscriber implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<OrderBookDto> orderbooks = null;
        try {
            orderbooks  = objectMapper.readValue(message.getBody(), List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("Loggn the data {}", orderbooks);
    }
}
