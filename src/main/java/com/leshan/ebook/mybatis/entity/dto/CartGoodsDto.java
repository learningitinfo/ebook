package com.leshan.ebook.mybatis.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartGoodsDto {
    private int id;         //商品id
    private String name;    //商品名字
    private String image;   //商品图片
    private BigDecimal salesprice;  //销售价
}
