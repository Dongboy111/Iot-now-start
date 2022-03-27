package com.ydh.rabbitmq.controller;


import com.alibaba.fastjson.JSONObject;
import com.ydh.rabbitmq.common.BaseData;
import com.ydh.rabbitmq.common.BaseR;
import com.ydh.rabbitmq.constants.CommonConstants;
import com.ydh.rabbitmq.entity.DeviceDataEntity;
import com.ydh.rabbitmq.feign.IDeviceOp;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device")
public class DeviceOp {
    @Autowired
    RabbitTemplate rabbitTemplate ;




    //这里应该启动消息发布者 由消费者去调用远程服务
    @PostMapping("/data/all")
    public BaseR getDeviceInfoById(@RequestBody JSONObject jsonObject){
        DeviceDataEntity baseData = jsonObject.toJavaObject(DeviceDataEntity.class) ;
        //对获取的参数进行rabbit 发送 并进行远程调用存库
        try{
            rabbitTemplate.convertAndSend(CommonConstants.RABBITMQ_EXCHANGE,CommonConstants.RABBITMQ_KEYS,baseData);
            return  BaseR.create("转发成功",200) ;


        }catch (Exception e ){
            e.printStackTrace();
            return BaseR.create("转发有异常了",402) ;

        }



    }


}
