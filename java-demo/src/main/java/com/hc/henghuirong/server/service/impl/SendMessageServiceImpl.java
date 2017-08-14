package com.hc.henghuirong.server.service.impl;

import com.hc.henghuirong.server.service.SendMessageService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Wu.Kang on 2017/4/14.
 */
@Service
public class SendMessageServiceImpl implements SendMessageService,RabbitTemplate.ConfirmCallback {
    @Override
    public void sendMessage(String exchange, String routineKey, String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
        Message message =new Message(content.getBytes(), messageProperties);
        rabbitTemplate.convertAndSend(exchange, routineKey, message, correlationId);
    }

    private RabbitTemplate rabbitTemplate;

    /**
     * 构造方法注入
     */
    @Autowired
    public SendMessageServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setConfirmCallback(this);
    }

    /**
     * 回调
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println(" 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息成功处理");
        } else {
            System.out.println("消息处理异常:" + cause);
        }
    }
}
