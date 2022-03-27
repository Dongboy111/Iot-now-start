package com.ydh.iotdeviceop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("iot_device_data")
public class DeviceDataEntity implements Serializable {

  private long userId;
  private long deviceId;
  private long recordId;
  private String timestamp;
  private String record;



}
