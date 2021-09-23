package com.leshan.ebook.service;

import com.leshan.ebook.mybatis.entity.Cart;

public interface CartService {
    //添加购物车方法，返回bool值表示添加是否成功
    public boolean addCart(Cart cart);
}
