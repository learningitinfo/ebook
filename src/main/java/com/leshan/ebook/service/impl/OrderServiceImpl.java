package com.leshan.ebook.service.impl;

import com.leshan.ebook.mapper.AddressMapper;
import com.leshan.ebook.mapper.OrderItemMapper;
import com.leshan.ebook.mapper.OrderMapper;
import com.leshan.ebook.mybatis.entity.Address;
import com.leshan.ebook.mybatis.entity.Order;
import com.leshan.ebook.mybatis.entity.OrderItem;
import com.leshan.ebook.mybatis.entity.dto.OrderDto;
import com.leshan.ebook.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private AddressMapper addressMapper;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public OrderDto makeOrder(int[] ids, int aid, int userid) {
        //1.向订单表中插入一条订单数据
        Order order = new Order();

        //1.1.生成订单编号
        order.setOrderno(generateOrderno());

        //1.2.设置用户id
        order.setUserid(userid);

        //1.3.通过收货地址id得到收货地址信息
        Address address = addressMapper.findById(aid);
        order.setAccept(address.getAccept());
        order.setTelphone(address.getTelphone());
        order.setAddress(address.getProvince()+address.getCity()+address.getArea()+address.getAddress());

        //1.4.计算总金额 = 数量 * 单价
        order.setMoney(orderMapper.totalPrice(ids));

        //1.5.向订单表中插入一条记录
        orderMapper.addOrder(order);


        //2.向订单详情表中插入订单商品信息
        //2.1.查询出商品id、数量、价格
        List<OrderItem> orderItems = orderMapper.findByIds(ids);

        //2.2.给item设置订单id
        for(OrderItem orderItem : orderItems){
            orderItem.setOrderid(order.getId());
        }

        //2.3.向订单详情表中插入数据
        orderItemMapper.addItem(orderItems);

        //3.删除购物车对应的购物车信息


        //4.返回结果：订单id、订单编号、订单金额

        return null;
    }
    public String generateOrderno(){
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

}
