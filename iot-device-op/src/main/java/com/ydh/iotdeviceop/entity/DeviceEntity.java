package com.ydh.iotdeviceop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("iot_device")
public class DeviceEntity {

    private  int userId ;//所属用户id
    private  int id ; //设备id
    private  String deviceIp ; //设备ip
    private  String deviceType ; //设备类型 (就是设备属于什么类型传感器)
}
