package com.ydh.iotauto.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private long id ;
    private String passwd ;
    private String  name;
    private String  salt;
    private String  email;

}
