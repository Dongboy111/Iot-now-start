package com.ydh.iotauto.common;

import javax.swing.*;

public class LoginResult extends BaseResult{

    public static LoginResult loginResult= new LoginResult() ;
    public static LoginResult success(Object data){
            loginResult.setCode(HttpStatus.SUCCESS);
            loginResult.setMsg("登录成功");
            loginResult.setData(data);
            return loginResult ;

    }
    public static LoginResult error(String msg,Object data){

        loginResult.setCode(HttpStatus.ERROR);
        loginResult.setMsg(msg);
        loginResult.setData(data);
        return loginResult ;
    }
}
