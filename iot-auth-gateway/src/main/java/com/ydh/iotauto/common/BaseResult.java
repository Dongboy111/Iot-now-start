package com.ydh.iotauto.common;


import lombok.Data;

import java.security.PublicKey;

@Data
public abstract   class  BaseResult {

    private int  code ;
    private String msg ;
    private Object data ;







}
