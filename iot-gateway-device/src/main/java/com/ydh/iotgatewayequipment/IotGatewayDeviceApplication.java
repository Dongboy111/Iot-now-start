package com.ydh.iotgatewayequipment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
public class IotGatewayDeviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(IotGatewayDeviceApplication.class,args) ;
    }
}
