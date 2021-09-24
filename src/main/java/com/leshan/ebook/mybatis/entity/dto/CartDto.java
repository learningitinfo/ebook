package com.leshan.ebook.mybatis.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartDto {
    private int id;             //id
    private int goodsid;        //商品id
    private BigDecimal price;   //商品的价格
    private int nums;           //商品数量
    private CartGoodsDto goods; //当前购物车对应的商品信息
}
