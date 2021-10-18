package com.leshan.ebook.service;

import com.github.pagehelper.PageInfo;
import com.leshan.ebook.mybatis.entity.Order;
import com.leshan.ebook.mybatis.entity.dto.OrderDto;

import java.util.Map;

public interface OrderService {
    //下订单方法
    public OrderDto makeOrder(int[] ids, int aid, int userid);

    //修改订单状态   参数：订单编号
    public int update(String orderno);

    /**
     * 根据用户编号和订单状态统计 订单数量和总金额
     * @param userId 用户编号
     * @return 订单数量和总金额
     */
    public Map<String,Object> totalOrder(Integer userId);

    /**
     * 根据用户编号和订单状态查询该用户的订单分页对象
     * @param userId 用户编号
     * @param status 订单状态
     * @param pageNum 页码
     * @param pageSize 每页记录数
     * @return 分页对象
     */
    public PageInfo<Order> getOrdersPageByUserIdAndStatus(Integer userId,String status,Integer pageNum,Integer pageSize);
}
