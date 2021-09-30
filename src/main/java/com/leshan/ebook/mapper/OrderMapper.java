package com.leshan.ebook.mapper;

import com.leshan.ebook.mybatis.entity.Order;
import com.leshan.ebook.mybatis.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface OrderMapper {
    //通过购物车的id查询所有商品的总金额
    public BigDecimal totalPrice(int[] ids);

    //添加订单方法
    public int addOrder(Order order);

    //查询当前订单所有商品的信息
    public List<OrderItem> findByIds(int[] ids);

    //修改订单状态
    public int update(String orderno);
}
