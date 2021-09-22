package com.leshan.ebook.mybatis.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Cart {
    private int id;             //id
    private int goodsid;        //商品id
    private BigDecimal price;   //商品的价格
    private int nums;           //商品数量
    private Date date;          //添加日期
}
