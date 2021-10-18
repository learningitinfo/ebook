package com.leshan.ebook.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leshan.ebook.mapper.GoodsMapper;
import com.leshan.ebook.mybatis.entity.Goods;
import com.leshan.ebook.mybatis.entity.dto.GoodsDto;
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
    public List<GoodsDto> findNewSet() {
        return goodsMapper.findNewSet();
    }

    @Override
    public List<GoodsDto> findHot() {
        return goodsMapper.findHot();
    }


    @Override
    public List<GoodsDto> searchBooksByKeywords(String name, Integer pageNum, Integer pageSize) {
        //使用分页组件设置pageNum和pageSize
        PageHelper.startPage(pageNum,pageSize);
        return goodsMapper.searchGoodsByKeywords(name);
    }

    @Override
    public PageInfo<GoodsDto> getPageByKeywords(String name, Integer pageNum, Integer pageSize) {
        //使用分页组件设置pageNum和pageSize
        PageHelper.startPage(pageNum,pageSize);
        //获取集合
        List<GoodsDto> list = goodsMapper.searchGoodsByKeywords(name);
        //创建PageInfo对象
        PageInfo<GoodsDto> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<GoodsDto> getGoodsByCategoryId(Integer categoryId, Integer pageNum, Integer pageSize) {
        //使用分页组件设置pageNum和pageSize
        PageHelper.startPage(pageNum,pageSize);
        //获取集合
        List<GoodsDto> list = goodsMapper.findGoodsByCategoryId(categoryId);
        //创建PageInfo对象
        PageInfo<GoodsDto> pageInfo = new PageInfo<>(list);
        //返回分页对象
        return pageInfo;
    }
}
