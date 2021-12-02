package com.turntabl.marketdata.config;

import com.turntabl.marketdata.service.MessagePublisher;
import com.turntabl.marketdata.service.impl.ChannelTwoMessageSubscriber;
import com.turntabl.marketdata.service.impl.RedisMessagePublisher;
import com.turntabl.marketdata.service.impl.RedisMessageSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
@Slf4j
public class RedisConfig {
    @Value("${market-data.variables.redis.topic}")
    private  String topic;
    @Value("${market-data.variables.redis.topic-ex2}")
    private  String topic2;


    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        var host = System.getenv("REDIS_HOST");
//        int port= Integer.parseInt(System.getenv("REDIS_PORT"));
        String password = System.getenv("REDIS_PASSWORD");
        log.info("Rei details {}", host);
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("localhost", 6379);
//        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        return template;
    }

    @Bean
    @Qualifier("messageListener")
    MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new RedisMessageSubscriber());
    }

//    @Bean
//    @Qualifier("channelTwoListenerAdapter")
//    MessageListenerAdapter channelTwoListenerAdapter() {
//        return new MessageListenerAdapter(new ChannelTwoMessageSubscriber());
//    }

    @Bean
    RedisMessageListenerContainer redisContainer( ) {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisConnectionFactory());
        container.addMessageListener(messageListener(), topic());
//        container.addMessageListener(channelTwoListenerAdapter(), topicForExchange2());
        return container;
    }

    @Bean
    MessagePublisher redisPublisher() {
        return new RedisMessagePublisher(redisTemplate(), topic());
    }

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic(topic);
    }


    @Bean
    ChannelTopic topicForExchange2() {
        return new ChannelTopic(topic2);
    }
}
