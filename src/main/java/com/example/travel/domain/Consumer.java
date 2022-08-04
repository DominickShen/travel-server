package com.example.travel.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Consumer {

    private Integer id;
    private String username;

    private String password;

    private Integer sex;

    private String phoneNum;

    private String email;

    private Date birth;

    private String intro;

    private String location;

    private String avator;

    private Date createTime;

    private Date updateTime;

}
