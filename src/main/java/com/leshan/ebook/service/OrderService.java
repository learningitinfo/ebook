package com.leshan.ebook.service;

import com.leshan.ebook.mybatis.entity.dto.OrderDto;

public interface OrderService {
    //下订单方法
    public OrderDto makeOrder(int[] ids, int aid, int userid);

    //修改订单状态   参数：订单编号
    public int update(String orderno);
}
