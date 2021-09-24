package com.leshan.ebook.controller;

import com.leshan.ebook.enums.Status;
import com.leshan.ebook.mybatis.entity.Cart;
import com.leshan.ebook.mybatis.entity.dto.CartDto;
import com.leshan.ebook.service.CartService;
import com.leshan.ebook.utils.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Resource
    private CartService cartService;

    @RequestMapping("/add")
    @ResponseBody
    public ResponseResult add(Cart cart, HttpSession session){
        //测试是否能正常得到数据
        System.out.println(cart);

        //得到用户id
        int userid = (Integer) session.getAttribute("userid");

        //将用户id设置到cart对象中
        cart.setUserid(userid);

        boolean result = cartService.addCart(cart);

        ResponseResult responseResult = new ResponseResult();
        if (result){
            responseResult.setCode(200);
            responseResult.setMessage("添加购物车成功");
        }else {
            responseResult.setCode(500);
            responseResult.setMessage("系统正忙，请稍后再试");
        }

        return responseResult;
    }

    //查询当前用户购物车信息
    @RequestMapping("/find")
    @ResponseBody
    public ResponseResult find(HttpSession session){
        //1.通过session得到当前用户id
        int userid = (Integer)session.getAttribute("userid");

        //2.通过userid作为查询条件调用CartService对应方法得到购物车信息
        List<CartDto> cartDtos = cartService.findByUserId(userid);

        //3.封装数据
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(200);
        responseResult.setStatus(Status.REQUEST_SUCCESS);
        responseResult.setMessage("获取数据成功");
        responseResult.setData(cartDtos);

        //返回数据
        return responseResult;
    }
}
