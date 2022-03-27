package com.ydh.rabbitmq.service;


import com.ydh.rabbitmq.common.BaseData;
import com.ydh.rabbitmq.constants.CommonConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

//@Service
public class DeviceOpService {

    @Autowired
    private RabbitTemplate rabbitTemplate ;

    //rabbit发送消息 原子性
    @Transient
    public boolean rabbitMQMessageInsert(BaseData baseData){


        rabbitTemplate.convertAndSend(CommonConstants.RABBITMQ_EXCHANGE,CommonConstants.RABBITMQ_KEYS,baseData);
            return true;

    }
}
