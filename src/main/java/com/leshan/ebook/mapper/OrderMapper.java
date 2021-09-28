package com.leshan.ebook.mapper;

import com.leshan.ebook.mybatis.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface OrderMapper {
    //通过购物车的id查询所有商品的总金额
    public BigDecimal totalPrice(int[] ids);

    //添加订单方法
    public int addOrder(Order order);
}
