package com.ydh.rabbitmq.feign;


import com.ydh.rabbitmq.common.BaseR;
import com.ydh.rabbitmq.entity.DeviceDataEntity;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "device-operation")
public interface IDeviceOp {
//
//    @GetMapping("/device/query/{id}")
//    BaseR getInfoById(@PathVariable(value = "id") int id );

    @PostMapping("/device/all")

    boolean insertInfoToTable(@RequestBody DeviceDataEntity deviceDataEntity);

}
