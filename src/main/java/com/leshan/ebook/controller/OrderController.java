package com.leshan.ebook.controller;

import com.leshan.ebook.utils.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/make")
    @ResponseBody
    public ResponseResult make(int[] ids,int aid){//购物车id、地址id
        for (int i = 0; i < ids.length; i++) {
            System.out.println(ids[i]);
        }
        System.out.println(aid);

        return null;
    }
}
