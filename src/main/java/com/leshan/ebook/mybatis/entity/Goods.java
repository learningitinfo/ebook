package com.leshan.ebook.mybatis.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data   //自动给所有的属性添加上setter和getter
public class Goods {
    private int id;         //图书id
    private String name;    //图书名
    private String goodsno; //商品编号
    private String author;  //作者
    private String publisher;   //出版社
    private String pubtime;     //出版时间
    private int categoryid;     //分类id
    private String description; //商品的描述
    private String image;       //商品图片
    private int stock;          //库存
    private BigDecimal marketprice; //存储小数，不会有精度问题
    private BigDecimal salesprice;  //销售价
    private BigDecimal score;       //评分
    private int remarknums;         //评论数
    private Date uptime;            //上架时间
    private int salesnums;          //销量
    private String newset;          //是否是新上架商品
    private String hot;             //是否是热卖商品
    private String status;          //商品状态
}
