package com.ydh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ydh.dao.UserDao;
import com.ydh.entity.User;
import com.ydh.service.UserService;
import com.ydh.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {

    @Autowired
    UserDao userDao ;

    @Override
    public User getByName(String name) {

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>() ;
        userQueryWrapper.select("*").like("name",name) ;
        User user = userDao.selectList(userQueryWrapper).get(0);
        return user;
    }


    @Override
    public Boolean register(User user) {
//        md5+salt +hash散列
        //生成随机盐
       try{
           String salt = SaltUtils.getSalt(8) ;
           user.setSalt(salt);

           Md5Hash md5Hash = new Md5Hash(user.getPasswd(),salt,1024) ;
           user.setPasswd(md5Hash.toHex());
           user.setStatus("1");

           save(user) ;
           return true ;
       }catch (Exception e){
           e.printStackTrace();
           return false ;
       }

    }
}
