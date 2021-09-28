package com.leshan.ebook.service;

import com.leshan.ebook.mybatis.entity.dto.OrderDto;

public interface OrderService {
    //下订单方法
    public OrderDto makeOrder(int[] ids,int aid);
}
