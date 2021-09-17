package com.leshan.ebook.service;

import com.leshan.ebook.mybatis.entity.Goods;

import java.util.List;

public interface GoodsService {
    //以id查询
    public Goods findById(int id);

    //查询新上架的商品
    public List<Goods> findNewSet();

    //查询热卖商品
    public List<Goods> findHot();
}
