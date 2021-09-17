package com.leshan.ebook.controller;

import com.leshan.ebook.mybatis.entity.Goods;
import com.leshan.ebook.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller   //表示当前类是一个controller类
@RequestMapping("/goods")
public class GoodsController {
    //注入service
    @Resource
    private GoodsService goodsService;

    //处理新上架商品的请求
    @RequestMapping("/newset")
    @ResponseBody  //将响应头中Content-Type的值设置为  application/json 代表以json格式向浏览器返回数据
    public List<Goods> findNewSet(){
        //调用service对应的方法
        List<Goods> goodsList = goodsService.findNewSet();
        //返回数据
        return goodsList;
    }
}
