package com.ydh.iotauto.util;

import lombok.Data;

/**
 * AuthResult作用是：
 *
 * @ClassName: AuthResult
 * @author: 郭秀志 jbcode@126.com
 * @date: 2020/7/31 21:04
 * @Copyright:
 */
@Data
public class AuthResult {
    private int code;
    private String msg;
    private String token;
    private String refreshToken;


    public AuthResult(int i, String s) {
        this.code = i;
        this.msg = s;
    }

    public AuthResult(int i, String success, String token, String refreshToken) {
        this.code = i;
        this.msg = success;
        this.token = token;
        this.refreshToken = refreshToken;
    }
}
