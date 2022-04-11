package com.ydh.iotauto.controller;


import com.ydh.iotauto.common.BaseResult;
import com.ydh.iotauto.common.LoginResult;
import com.ydh.iotauto.entity.User;
import com.ydh.iotauto.feign.IUserFeign;


import com.ydh.iotauto.util.RedisUtils;
import com.ydh.iotauto.util.TokenUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping("/test")
public class LoginController {
    @Autowired
    StringRedisTemplate stringRedisTemplate ;
    @Autowired
    RedisUtils redisUtils ;



//    @RequiresRoles("admin")
    @RequestMapping("/test1")
    public String getTest1(){
        return TokenUtils.genToken("shaoyadong","dkljfajg");
    }


    @GetMapping("/test2")
    public String getTest2(){
        return "这是没有权限" ;
    }

    @PostMapping("/login")
    public LoginResult login(@RequestBody User user) {
//        System.out.println(user);

        Subject subject = SecurityUtils.getSubject();


        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPasswd());

        try{
            String token2 = redisUtils.get(token.getUsername()) ;
            HashMap<String,String > hashMap = new HashMap<>() ;
            hashMap.put(token.getUsername(),token2) ;
            return LoginResult.success(hashMap) ;

        }catch (Exception e){
             ;
        }
        try {
            subject.login(token);


            HashMap<String,String > hashMap = new HashMap<>() ;
            System.out.println(token.getUsername());
            String token1 = TokenUtils.genToken(token.getUsername(),"idfjaljgea") ;
            System.out.println("token");
            System.out.println(token1);
            hashMap.put("token3",token1) ;

            redisUtils.set(token.getUsername(),token1);

            //在这里将身份信息和token 加入到redis
            /*

             */

            return LoginResult.success(hashMap);
        } catch (UnknownAccountException e) {
            return LoginResult.error("未知账户","");
        } catch (IncorrectCredentialsException e) {
            return LoginResult.error("密码错误","");
        }
    }

    @RequestMapping("/logout")
    public String logout(@RequestParam String name){
        SecurityUtils.getSubject().logout();

        return "已经登出" ;
    }


}
