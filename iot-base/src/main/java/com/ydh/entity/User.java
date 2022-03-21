package com.ydh.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("iot_user")
public class User {

    private long id ;
    private String passwd ;
    private String  name;
    private String  salt;
    private String  email;

}
