package com.ydh.rabbitmq.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class DeviceDataEntity implements Serializable {

    private long userId;
    private long deviceId;
    private long recordId;
    private String timestamp;
    private String record;



}
