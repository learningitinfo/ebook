package com.leshan.ebook.mybatis.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItem {
    private int id;
    private int orderid;
    private int goodsid;
    private int nums;
    private BigDecimal price;
}
