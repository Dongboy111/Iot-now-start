package com.ydh.rabbitmq.two;


import com.rabbitmq.client.Channel;
import com.ydh.rabbitmq.utils.RabbitMqUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class ProducterWorker {

    public  static  final  String QUEUE_NAME = "hello" ;

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel() ;
        channel.queueDeclare(QUEUE_NAME,false,false,false,null) ;
//        发消息
//        String message = "hello word" ;
        /*
        1,发送到哪个交换机
        2，路由的key 值是哪个 本次是队列的名称
        3，其他参数信息
        4，发送消息的消息体
         */

        Scanner scanner = new Scanner(System.in) ;
        while (scanner.hasNext()){
            String message = scanner.next() ;
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes(StandardCharsets.UTF_8));
            System.out.println("发送完毕");

        }


    }
}
