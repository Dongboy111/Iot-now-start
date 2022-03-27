package com.ydh.rabbitmq.config;



import com.alibaba.fastjson.JSON;
import com.ydh.rabbitmq.common.BaseData;
import com.ydh.rabbitmq.constants.CommonConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.rowset.serial.SerialStruct;
import java.beans.Transient;


/**
 * RabbitMQ配置类
 * 采取广播形式
 */
@Configuration
public class RabbitMQListenerConfig {



        @Transient
        @RabbitListener(bindings = @QueueBinding(
                value = @Queue(name = CommonConstants.RABBITMQ_QUEUE),
                exchange = @Exchange(name = CommonConstants.RABBITMQ_EXCHANGE,type = ExchangeTypes.DIRECT),//交换机的名称 和方式 为广播
                key = CommonConstants.RABBITMQ_KEYS//绑定的key 值 只有发送者允许这个key 才能收到信息
        ))
        public void listenDirectQueue(String baseData){


        }

}



//    //队列 起名：TestDirectQueue
//    @Bean
//    public Queue TestDirectQueue() {
//        // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
//        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
//        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
//        //   return new Queue("TestDirectQueue",true,true,false);
//
//        //一般设置一下队列的持久化就好,其余两个就是默认false
//        return new Queue(CommonConstants.RABBITMQ_QUEUE,true);
//    }
//
//    //Direct交换机 起名：TestDirectExchange
//    @Bean
//    DirectExchange TestDirectExchange() {
//        //  return new DirectExchange("TestDirectExchange",true,true);
//        return new DirectExchange(CommonConstants.RABBITMQ_EXCHANGE,true,false);
//    }
//
//    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
//    @Bean
//    Binding bindingDirect() {
//        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
//    }
//
//
//
//    @Bean
//    DirectExchange lonelyDirectExchange() {
//        return new DirectExchange("lonelyDirectExchange");
//    }