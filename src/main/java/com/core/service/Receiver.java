package com.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description
 * @date 2018/6/26 15:33
 */
@Service
@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
public class Receiver {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private Logger logger = LoggerFactory.getLogger(Receiver.class);

    @RabbitHandler
    public void receive(String msg) {
        logger.info("接收消息：" + msg);
    }

}
