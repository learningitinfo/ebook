package com.leshan.ebook.service.impl;

import com.leshan.ebook.mybatis.entity.dto.OrderDto;
import com.leshan.ebook.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderDto makeOrder(int[] ids, int aid) {
        //1.向订单表中插入一条订单数据


        //2.向订单详情表中插入订单商品信息


        //3.删除购物车对应的购物车信息


        //4.返回结果：订单id、订单编号、订单金额

        return null;
    }
}
