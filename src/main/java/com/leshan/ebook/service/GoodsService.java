package com.leshan.ebook.service;

import com.github.pagehelper.PageInfo;
import com.leshan.ebook.mybatis.entity.Goods;
import com.leshan.ebook.mybatis.entity.dto.GoodsDto;

import java.util.List;

public interface GoodsService {
    //以id查询
    public Goods findById(int id);

    //查询新上架的商品
    public List<GoodsDto> findNewSet();

    //查询热卖商品
    public List<GoodsDto> findHot();

    /**
     * 分页查询根据图书名称的关键字查询图书
     * @param name 图书名称的关键字
     * @param pageNum 页码
     * @param pageSize 每页的记录数
     * @return 一页的图书集合
     */
    public List<GoodsDto> searchBooksByKeywords(String name,Integer pageNum,Integer pageSize);

    /**
     * 获取分页对象
     * @param name 图书名称的关键字
     * @param pageNum 页码
     * @param pageSize 每页的记录数
     * @return PageInfo对象
     */
    public PageInfo<GoodsDto> getPageByKeywords(String name,Integer pageNum,Integer pageSize);

    /**
     * 根据分类编号获取该类别下的所有图书，将图书集合封装为分页对象返回
     * @param categoryId 分类编号
     * @param pageNum 页码
     * @param pageSize 每页的记录数
     * @return
     */
    public PageInfo<GoodsDto> getGoodsByCategoryId(Integer categoryId,Integer pageNum,Integer pageSize);
}
