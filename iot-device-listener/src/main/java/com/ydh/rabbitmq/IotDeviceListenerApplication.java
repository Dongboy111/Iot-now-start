package com.ydh.rabbitmq;

import com.ydh.rabbitmq.feign.IDeviceOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;

@EnableFeignClients
@SpringBootApplication
public class IotDeviceListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IotDeviceListenerApplication.class, args);
    }

//    @Autowired
//    private IDeviceOp iDeviceOp ;

//    @GetMapping("/feign")
//    public String test(){
//        iDeviceOp.getInfoById(1) ;
//        return "dong" ;
//    }

}
