package com.leshan.ebook.mybatis.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;             //id
    private String account;     //账号
    private String password;    //密码
    private String email;       //邮箱
    private String avatar;      //头像
    private int score;          //积分
    private Date regtime;       //注册时间
    private String status;      //状态
}
