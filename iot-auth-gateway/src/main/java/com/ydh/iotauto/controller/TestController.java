package com.ydh.iotauto.controller;

import com.ydh.iotauto.util.RedisUtils;
import com.ydh.iotauto.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test1")
public class TestController {
    @Autowired
    StringRedisTemplate stringRedisTemplate ;
    @Autowired
    RedisUtils redisUtils ;
    @RequestMapping("test")
    public String tess(){
        return TokenUtils.genToken("shaoyadong","dddddaga") ;
    }
}


