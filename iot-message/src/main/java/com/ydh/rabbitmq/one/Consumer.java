package com.ydh.rabbitmq.one;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public  static  final  String QUEUE_NAME = "hello" ;

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
        //声明接受消息
        DeliverCallback deliverCallback = (consumerTag,message)->{
            System.out.println(new String(message.getBody()));
        } ;
        //取消消息消费
        CancelCallback cancelCallback = cousumerTag->{
            System.out.println("消费被中断");
        };
        /*
        消费者 消费消息
        1.消费哪个队列
        2，消费成功之后是否要自动应答 true 代表自动应答
        3，消费者未消费成功的回调
        4，消费者取消 消费的回调
         */
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback) ;
    }
}
