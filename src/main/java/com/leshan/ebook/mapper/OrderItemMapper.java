package com.leshan.ebook.mapper;

import com.leshan.ebook.mybatis.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderItemMapper {
    public int addItem(List<OrderItem> orderItems);
}
