package com.ydh.iotdeviceop.controller;



import com.ydh.iotdeviceop.common.BaseData;
import com.ydh.iotdeviceop.common.BaseR;
import com.ydh.iotdeviceop.entity.DeviceDataEntity;
import com.ydh.iotdeviceop.service.IDeviceDataService;
import com.ydh.iotdeviceop.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device")
public class DeviceRegistered {


    @Autowired
    IDeviceService iDeviceService ;

    @Autowired
    IDeviceDataService iDeviceDataService ;

    @GetMapping("/query/{id}")
    public BaseR getInfoById(@PathVariable int id ){
            return  BaseR.create(iDeviceService.getById(1),200) ;
    }

    @PostMapping("/all")
    public boolean insertInfoToTable(@RequestBody  DeviceDataEntity deviceDataEntity){
        return iDeviceDataService.save(deviceDataEntity) ;
//        return true ;


    }
}
