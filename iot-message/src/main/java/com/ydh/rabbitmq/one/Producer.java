package com.ydh.rabbitmq.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Producer {
    //队列名称
    public static  final String QUEUE_NAME= "hello" ;

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建一个链接工厂
        ConnectionFactory factory = new ConnectionFactory() ;
        //工厂ip 链接rabbitmq的队列
        factory.setHost("192.168.159.11");
        factory.setUsername("admin");
        factory.setPassword("admin");

//        创建链接
        Connection connection = factory.newConnection() ;
        Channel channel = connection.createChannel() ;
//        生成一个队列
        /*
        1,队列名称
        2，队列里面的消息是否持久化 默认强狂下消息存储在内存中
        3,该队列是否只供一个二小分着进行消费 是否进行信息共享 true 可以多个消费者消费 false 只能一个消费者消费i、
        4，是否自动删除 最后一个消费者断开链接之后 该队列是否自动删除 true 表示自动删除
        5,其他参数
         */
        channel.queueDeclare(QUEUE_NAME,false,false,false,null) ;
//        发消息
        String message = "hello word" ;
        /*
        1,发送到哪个交换机
        2，路由的key 值是哪个 本次是队列的名称
        3，其他参数信息
        4，发送消息的消息体
         */
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes(StandardCharsets.UTF_8));
        System.out.println("发送完毕");
    }
}
