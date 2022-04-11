package com.ydh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ydh.entity.User;
import org.springframework.stereotype.Service;



public interface UserService extends IService<User> {

    User getByName(String name) ;
    Boolean register(User user) ;

}
