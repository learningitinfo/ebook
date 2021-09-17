package com.leshan.ebook.service.impl;

import com.leshan.ebook.mapper.GoodsMapper;
import com.leshan.ebook.mybatis.entity.Goods;
import com.leshan.ebook.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service  //表示当前类是一个service层的类
public class GoodsServiceImpl implements GoodsService {

    @Resource  //注入一个mapper
    private GoodsMapper goodsMapper;

    @Override
    public Goods findById(int id) {
        //调用mapper对应的方法
        return goodsMapper.findById(id);
    }

    @Override
    public List<Goods> findNewSet() {
        return goodsMapper.findNewSet();
    }

    @Override
    public List<Goods> findHot() {
        return goodsMapper.findHot();
    }
}
