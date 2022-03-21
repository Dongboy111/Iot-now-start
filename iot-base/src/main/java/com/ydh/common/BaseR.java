package com.ydh.common;

import lombok.Data;

@Data
public class BaseR {
    //返回状态码
    private int code ;

    //返回内容
    private Object data ;

    // 通用静态工厂方法
    public static BaseR create(Object data){
        // 设置默认code为0，表示访问正常
        return BaseR.create(data, 0);
    }


    // 静态工厂方法，重写Code和Data
    public static BaseR create(Object data, int code){
        BaseR returnType = new BaseR();
        returnType.setCode(code);
        returnType.setData(data);
        return returnType;
    }





}
