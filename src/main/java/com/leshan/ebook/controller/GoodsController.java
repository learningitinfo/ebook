package com.leshan.ebook.controller;

import com.github.pagehelper.PageInfo;
import com.leshan.ebook.mybatis.entity.Goods;
import com.leshan.ebook.mybatis.entity.dto.GoodsDto;
import com.leshan.ebook.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<GoodsDto> findNewSet(){
        //调用service对应的方法
        List<GoodsDto> goodsList = goodsService.findNewSet();
        //返回数据
        return goodsList;
    }

    //处理热卖商品请求
    @RequestMapping("/hot")
    @ResponseBody
    public List<GoodsDto> findHot(){
        List<GoodsDto> goodsDtoList = goodsService.findHot();
        return  goodsDtoList;
    }

    //以id作为查询条件，查询商品的详细信息
    @RequestMapping("/findbyid")
    @ResponseBody
    public Goods findGoodsById(int id){
        return goodsService.findById(id);
    }

    @RequestMapping("/searchGoodsByKeywords")
    @ResponseBody
    public List<GoodsDto> searchGoodsByKeywords(@RequestParam(value="name",required = false,defaultValue = "")String name,
                                                @RequestParam(value="pageNum",required = false,defaultValue = "1")Integer pageNum,
                                                @RequestParam(value="pageSize",required = false,defaultValue = "15")Integer pageSize){
        return goodsService.searchBooksByKeywords(name,pageNum,pageSize);
    }

    @RequestMapping("/getPageByKeywords")
    @ResponseBody
    public PageInfo<GoodsDto> getPageByKeywords(@RequestParam(value="name",required = false,defaultValue = "")String name,
                                                @RequestParam(value="pageNum",required = false,defaultValue = "1")Integer pageNum,
                                                @RequestParam(value="pageSize",required = false,defaultValue = "15")Integer pageSize){
        return goodsService.getPageByKeywords(name,pageNum,pageSize);
    }

    @RequestMapping("/getGoodsByCategoryId")
    @ResponseBody
    public PageInfo<GoodsDto> getGoodsByCategoryId(@RequestParam(value="categoryId",required = false,defaultValue = "0")Integer categoryId,
                                                   @RequestParam(value="pageNum",required = false,defaultValue = "1")Integer pageNum,
                                                   @RequestParam(value="pageSize",required = false,defaultValue = "15")Integer pageSize){
        return goodsService.getGoodsByCategoryId(categoryId,pageNum,pageSize);
    }

}
