package com.ydh.controller;


import com.ydh.entity.User;
import com.ydh.service.UserService;
import com.ydh.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    UserService userService ;

    @PostMapping("register")
    public String register(User user){
        System.out.println(user);
        Boolean flag = userService.register(user) ;
        if (flag){
            return "注册成功" ;
        }else {
            return "注册失败" ;
        }
    }
}
