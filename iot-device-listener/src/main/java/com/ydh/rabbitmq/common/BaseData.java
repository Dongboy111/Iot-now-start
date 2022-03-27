package com.ydh.rabbitmq.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseData implements Serializable {
    //返回内容
    private String deviceID ;
    private String userID ;
    private Object data;
    private String timeStamp;


}
