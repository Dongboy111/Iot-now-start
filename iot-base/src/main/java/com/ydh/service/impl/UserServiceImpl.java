package com.ydh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ydh.dao.UserDao;
import com.ydh.entity.User;
import com.ydh.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {

}
