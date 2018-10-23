package com.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description
 * @date 2018/6/26 15:33
 */
@Service
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private Logger logger = LoggerFactory.getLogger(Sender.class);

    public void send() {
        logger.info("发送消息...");
        amqpTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, "测试测试测试.....");
    }

}
