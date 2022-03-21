package com.ydh.service;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserserviceTest {
    @Autowired
    UserService userService ;

    @Test
    public void dong(){

        System.out.println(userService.getById(1).toString());
    }
}
