package com.ydh.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/*
链接工厂信道的工具类
 */
public class RabbitMqUtils {
    public static Channel getChannel() throws IOException, TimeoutException {
        //创建一个链接工厂
        ConnectionFactory factory = new ConnectionFactory() ;
        //工厂ip 链接rabbitmq的队列
        factory.setHost("192.168.159.11");
        factory.setUsername("admin");
        factory.setPassword("admin");

        //        创建链接
        Connection connection = factory.newConnection() ;
        Channel channel = connection.createChannel() ;
        return channel ;
    }
}
