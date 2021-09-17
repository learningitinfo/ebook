package com.leshan.ebook.mybatis.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsDto {
    private int id;         //图书id
    private String name;    //图书名
    private String description; //商品的描述
    private String image;       //商品图片
    private BigDecimal marketprice; //存储小数，不会有精度问题
    private BigDecimal salesprice;  //销售价
}
