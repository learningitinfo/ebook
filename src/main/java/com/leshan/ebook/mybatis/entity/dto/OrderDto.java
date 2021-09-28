package com.leshan.ebook.mybatis.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDto {
    private int id;             //订单id
    private String orderno;     //订单编号
    private BigDecimal price;   //订单总价
}
