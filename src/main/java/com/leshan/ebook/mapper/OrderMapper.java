package com.leshan.ebook.mapper;

import com.leshan.ebook.mybatis.entity.Order;
import com.leshan.ebook.mybatis.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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

    /**
     * 根据用户编号和订单状态统计 订单数量和总金额
     * @param userId 用户编号
     * @return 订单数量和总金额
     */
    public Map<String,Object> totalOrder(Integer userId);

    /**
     * 根据用户编号和状态获取订单集合
     * 如果用户状态为null，查询该用户所有的订单
     * 如果用户编号为null,查询所有用户的订单
     * @param userId 用户编号
     * @param status 用户状态
     * @return 订单集合
     */
    public List<Order> getOrdersByUserIdAndStatus(@Param("userId")Integer userId,@Param("status")String status);
}
