package com.leshan.ebook.service.impl;

import com.leshan.ebook.mybatis.entity.Order;
import com.leshan.ebook.mybatis.entity.dto.OrderDto;
import com.leshan.ebook.service.OrderService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {

    private String generateOrderno(){
        //生成订单编号：WN + 20200903150222 + 6885(随机)
        String orderno = "LS";

        //获取当前时间
        Date now = new Date();
        //创建格式化器
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = simpleDateFormat.format(now);

        //生成随机的四位数
        Random random = new Random();
        String num = random.nextInt(10000) + "";  //0-9999  0006
        for (int i = 0; i <4 - num.length(); i++) {
            num = "0" + num;
        }

        //返回结果
        return orderno + time + num;
    }

    @Override
    public OrderDto makeOrder(int[] ids, int aid, int userid) {
        //1.向订单表中插入一条订单数据
        Order order = new Order();

        //1.1.生成订单编号
        order.setOrderno(generateOrderno());

        //2.向订单详情表中插入订单商品信息


        //3.删除购物车对应的购物车信息


        //4.返回结果：订单id、订单编号、订单金额

        return null;
    }
}
