package com.leshan.ebook.mybatis.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {
    private int id;             //订单id
    private String orderno;     //订单编号
    private int userid;         //用户id
    private Date ordertime;     //下单时间
    private String accept;      //收货人
    private String telphone;    //手机
    private String address;     //地址
    private BigDecimal money;   //订单金额
    private String paytype;     //支付方式
    private Date paytime;       //支付时间
    private String status;      //订单状态
}
