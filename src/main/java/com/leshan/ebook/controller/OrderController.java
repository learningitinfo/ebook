package com.leshan.ebook.controller;

import com.leshan.ebook.enums.Status;
import com.leshan.ebook.mybatis.entity.dto.OrderDto;
import com.leshan.ebook.service.OrderService;
import com.leshan.ebook.utils.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping("/make")
    @ResponseBody
    public ResponseResult make(int[] ids, int aid, HttpSession session){//购物车id、地址id
        int userid = (Integer)session.getAttribute("userid");

        //调用service实现下订单
        OrderDto orderDto = orderService.makeOrder(ids, aid, userid);

        //
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(200);
        responseResult.setStatus(Status.REQUEST_SUCCESS);
        responseResult.setMessage("下单成功");
        responseResult.setData(orderDto);

        return responseResult;
    }
}
