package com.ydh.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ydh.rabbitmq.common.BaseData;
import com.ydh.rabbitmq.constants.CommonConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class test1 {

    @Autowired
    RabbitTemplate rabbitTemplate ;


    @Test
    public void test(){


        BaseData baseData = new BaseData() ;
        baseData.setData("dddd");
        baseData.setDataID("kagshgire");
        baseData.setUserID("hdsghakeg");
        baseData.setTimeStamp("15569375932");
        String json = JSON.toJSONString(baseData) ;
        System.out.println(json);
        rabbitTemplate.convertAndSend(CommonConstants.RABBITMQ_EXCHANGE,CommonConstants.RABBITMQ_KEYS,baseData);
        System.out.println("发送成功");
    }
}
