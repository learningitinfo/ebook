package com.leshan.ebook.service.impl;

import com.leshan.ebook.mapper.CartMapper;
import com.leshan.ebook.mybatis.entity.Cart;
import com.leshan.ebook.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CartServiceImpl implements CartService {
    @Resource
    private CartMapper cartMapper;

    @Override
    public boolean addCart(Cart cart) {
        //1.先查询原来是否添加过当前商品
        Cart result = cartMapper.findByUseridAndGoodsid(cart.getUserid(),cart.getGoodsid());

        int flag = 0;
        //2.判断
        if (result != null){
            //之前添加过，在原来的数量上加上现在数量
            flag = cartMapper.updateCart(result.getId(),cart.getNums());
        }else {
            //之前没添加过
            flag = cartMapper.addCart(cart);
        }
        //根据flag的值返回不同的结果，如果flag>0返回true，表示操作成功
        return flag > 0 ? true : false;
    }
}
