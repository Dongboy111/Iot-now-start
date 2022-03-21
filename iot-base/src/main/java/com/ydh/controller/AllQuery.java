package com.ydh.controller;


import com.ydh.entity.User;
import com.ydh.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ydh.common.BaseR;
@Controller
@ResponseBody
@RequestMapping("/query")
@Api("关于查询方面的操作")
public class AllQuery {

    @Autowired
    private UserService userService ;

    @ApiOperation(value = "根据id查用户", notes = "")
    @GetMapping("/user/{id}")
    public BaseR getInfoById (@PathVariable int id){
        User user = userService.getById(id) ;
        if (user==null){
            return   BaseR.create(user,400);
        }else {
            return   BaseR.create(user,200);
        }
    }

}
