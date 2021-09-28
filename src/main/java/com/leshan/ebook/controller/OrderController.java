package com.leshan.ebook.controller;

import com.leshan.ebook.utils.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/make")
    @ResponseBody
    public ResponseResult make(int[] ids, int aid, HttpSession session){//购物车id、地址id
        int userid = (Integer)session.getAttribute("userid");


        return null;
    }
}
