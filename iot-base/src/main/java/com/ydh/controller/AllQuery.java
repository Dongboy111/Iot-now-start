package com.ydh.controller;


import com.ydh.entity.User;
import com.ydh.service.UserService;
import com.ydh.utils.StmpUtils;
import com.ydh.utils.VerificationCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.ydh.common.BaseR;

import javax.mail.MessagingException;

@Controller
@ResponseBody
@RequestMapping("/query")
@Api("关于查询方面的操作")
public class AllQuery {

    @Autowired
    private UserService userService ;

//    @ApiOperation(value = "根据id查用户", notes = "")
//    @GetMapping("/user/{id}")
//    public BaseR getInfoById (@PathVariable int id){
//        User user = userService.getById(id) ;
//        if (user==null){
//            return   BaseR.create(user,400);
//        }else {
//            return   BaseR.create(user,200);
//        }
//    }

    @Autowired
    StmpUtils stmpUtils ;

    @GetMapping("/testyou")
    public String  sendStmp(){
        if (stmpUtils.sendMessage("shaoyadongneu@163.com","主题","test2")){
            return "ok" ;
        }else {
            return "faild" ;
        }

    }

    @GetMapping("/testhtml")
    public String testHtml() {
        String code = VerificationCode.getCode(8) ;
        if (stmpUtils.sendMessageHtml("shaoyadongneu@163.com","YDH-IOT:注册账号","",code)){
            return "ok" ;
        }else {
            return "faild" ;
        }
    }

    @ApiOperation(value = "根据名字查用户", notes = "")
    @GetMapping("/user/{name}")
    public User getInfoByName (@PathVariable(value = "name") String name ){
        try{
            User user = userService.getByName(name) ;
            return user ;
        }catch (Exception e){
            return null ;

        }


//        System.out.println(user);


    }

    @GetMapping("/user/test")
    public User getTest (){
        User user = userService.getById(1) ;
        return user ;

    }



}
