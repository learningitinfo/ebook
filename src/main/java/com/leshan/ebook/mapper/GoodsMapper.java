package com.leshan.ebook.mapper;

import com.leshan.ebook.mybatis.entity.Goods;
import com.leshan.ebook.mybatis.entity.dto.GoodsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper   //表明该接口是一个mapper
public interface GoodsMapper {
    //是以商品id作为查询条件查询商品数据
    public Goods findById(int id);

    //查询新上架的商品
    public List<GoodsDto> findNewSet();

    //查询热卖商品
    public List<GoodsDto> findHot();

    /**
     * 根据分类编号获取所有图书
     * @param categoryId 分类编号
     * @return 图书集合
     */
    public List<GoodsDto> findGoodsByCategoryId(Integer categoryId);

    /**
     * 根据图书名称查询所有的图书
     * @param name 图书名称的关键字
     * @return
     */
    public List<GoodsDto> searchGoodsByKeywords(@Param("name")String name);
}
