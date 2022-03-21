package com.ydh.iotdeviceop.controller;



import com.ydh.iotdeviceop.common.BaseR;
import com.ydh.iotdeviceop.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device")
public class DeviceRegistered {


    @Autowired
    IDeviceService iDeviceService ;

    @GetMapping("/query/{id}")
    @ResponseBody
    public BaseR getInfoById(@PathVariable int id ){
            return  BaseR.create(iDeviceService.getById(1),200) ;
    }


}
