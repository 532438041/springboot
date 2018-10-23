package com.core.service;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description
 * @date 2018/6/26 15:33
 */
@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "spring-boot-simple";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }

}
