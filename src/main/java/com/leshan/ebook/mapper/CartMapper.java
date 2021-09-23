package com.leshan.ebook.mapper;

import com.leshan.ebook.mybatis.entity.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartMapper {
    //1.通过用户id、商品id作为查询条件查询购物车信息
    //加了@Param之后，mybatis会将参数放到map中，@Param中的字符串就是key，形参的值就是value
    public Cart findByUseridAndGoodsid(@Param("userid") int userid, @Param("goodsid") int goodsid);

    //2.更新购物车：通过购物车的id作为查询条件进行更新，参数：购物车id、新增加的数量
    public int updateCart(@Param("id") int id,@Param("nums") int nums);

    //3.新增一条数据
    public int addCart(Cart cart);
}
