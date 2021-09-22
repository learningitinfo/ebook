package com.leshan.ebook.controller;

import com.leshan.ebook.mybatis.entity.Cart;
import com.leshan.ebook.utils.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cart")
public class CartController {

    @RequestMapping("/add")
    @ResponseBody
    public ResponseResult add(Cart cart){
        //测试是否能正常得到数据
        System.out.println(cart);
        return null;
    }
}
