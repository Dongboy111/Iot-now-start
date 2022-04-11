package com.ydh.utils;


import java.util.Random;

//关于盐的工具类
public class SaltUtils {

    public  static String getSalt(int n){
        char[] chars = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890!@#$%^&*()".toCharArray() ;
        StringBuilder sb = new StringBuilder() ;
        for(int i=0;i<n;i++){
            char temp = chars[new Random().nextInt(chars.length)] ;
            sb.append(temp) ;
        }
        return sb.toString() ;

    }

}
