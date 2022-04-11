package com.ydh.iotauto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class IotAuthGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(IotAuthGatewayApplication.class, args);
    }

}
