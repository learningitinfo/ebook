package com.leshan.ebook.mybatis.entity;

import lombok.Data;

@Data
public class Address {
    private int id;             //id
    private int userid;         //用户id
    private String accept;      //收货人
    private String telphone;    //手机号
    private String province;    //省份
    private String city;        //城市
    private String area;        //区县
    private String address;     //详细地址
    private String type;        //是否是默认收货地址
}
