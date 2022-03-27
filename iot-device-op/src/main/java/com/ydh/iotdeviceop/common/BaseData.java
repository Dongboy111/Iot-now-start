package com.ydh.iotdeviceop.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseData implements Serializable {
    //返回内容
    private String deviceId ;
    private String userId ;
    private Object data;
    private String timestamp;


}
