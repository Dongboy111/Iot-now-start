package com.ydh.utils;


import java.util.Random;

public class VerificationCode {

    public static String  getCode(int n){

        char [] chars = "1234567890".toCharArray() ;
        StringBuilder sb = new StringBuilder() ;
        for(int i=0;i<n;i++){
            char temp = chars[new Random().nextInt(chars.length)] ;
            sb.append(temp) ;
        }
        return sb.toString() ;

    }
}
