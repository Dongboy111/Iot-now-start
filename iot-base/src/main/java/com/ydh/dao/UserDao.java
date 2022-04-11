package com.ydh.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ydh.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
;

@Mapper
public interface UserDao extends BaseMapper<User> {


}
