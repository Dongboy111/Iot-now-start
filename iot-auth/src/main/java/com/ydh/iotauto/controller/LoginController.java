package com.ydh.iotauto.controller;

import com.ydh.iotauto.util.AuthResult;
import com.ydh.iotauto.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @description 登录后生成token，及刷新token。
 * @ClassName: LoginController
 * @author: 郭秀志 jbcode@126.com
 * @date: 2020/7/31 21:39
 * @Copyright:
 */
@RestController
public class LoginController {
    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 登录认证
     *
     * @param username 用户名
     * @param password 密码
     */
    @GetMapping("/login")
    public AuthResult login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "admin".equals(password)) {//这里应该调用一个服务接口
            //查询出用户权限
            String roles = "admin,query";
            //生成token
            String token = JWTUtil.generateToken(username, roles);

            //生成refreshToken
            String refreshToken = UUID.randomUUID().toString().replace("-", "");

            //数据放入redis
            redisTemplate.opsForHash().put(refreshToken, "token", token);
            redisTemplate.opsForHash().put(refreshToken, "username", username);
            redisTemplate.opsForHash().put(refreshToken, "roles", roles);

            //设置token的过期时间
            redisTemplate.expire(refreshToken, JWTUtil.REFRESH_TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);

            return new AuthResult(0, "success", token, refreshToken);
        } else {
            return new AuthResult(1001, "username or password error");
        }
    }

    /**
     * 刷新token
     */
    @GetMapping("/refreshToken")
    public AuthResult refreshToken(@RequestParam String refreshToken) {
        String username = (String) redisTemplate.opsForHash().get(refreshToken, "username");
        String roles = (String) redisTemplate.opsForHash().get(refreshToken, "roles");
        if (StringUtils.isEmpty(username)) {
            return new AuthResult(1003, "refreshToken error");
        }

        //生成新的token
        String newToken = JWTUtil.generateToken(username, roles);
        redisTemplate.opsForHash().put(refreshToken, "token", newToken);
        return new AuthResult(0, "success", newToken, refreshToken);
    }

    @GetMapping("/")
    public String index() {
        return "auth-service: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
