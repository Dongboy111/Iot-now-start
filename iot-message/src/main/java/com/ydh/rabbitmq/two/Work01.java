package com.ydh.rabbitmq.two;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.ydh.rabbitmq.utils.RabbitMqUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/*
工作线程1
 */
public class Work01 {

    public static final String QUEUE_NAME = "hello" ;

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel() ;

        //声明接受消息
        DeliverCallback deliverCallback = (consumerTag,message)->{
            System.out.println("接受到的消息："+new String(message.getBody()));
        } ;
        //取消消息消费
        CancelCallback cancelCallback = cousumerTag->{
            System.out.println("消费被中断");
        };
        System.out.println("C2等到接收消息，，，，");
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback) ;
        //不关闭的话一直等待



    }
}
