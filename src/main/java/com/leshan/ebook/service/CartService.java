package com.leshan.ebook.service;

import com.leshan.ebook.mybatis.entity.Cart;
import com.leshan.ebook.mybatis.entity.dto.CartDto;

import java.util.List;

public interface CartService {
    //添加购物车方法，返回bool值表示添加是否成功
    public boolean addCart(Cart cart);

    //通过userid得到用户购物车信息
    public List<CartDto> findByUserId(int userid);

    //更新购物车数量
    public boolean update(Cart cart);
}
