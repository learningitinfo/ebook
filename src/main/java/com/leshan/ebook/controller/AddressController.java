package com.leshan.ebook.controller;

import com.leshan.ebook.enums.Status;
import com.leshan.ebook.service.AddressService;
import com.leshan.ebook.utils.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;

    @RequestMapping("/info")
    @ResponseBody
    public ResponseResult info(HttpSession session){
        //通过当前用户的id查询出当前用户的收货地址
        int userid = (Integer)session.getAttribute("userid");

        //调用service查询出地址信息
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(200);
        responseResult.setMessage("获取成功");
        responseResult.setStatus(Status.REQUEST_SUCCESS);
        responseResult.setData(addressService.findByUserId(userid));

        //返回数据
        return responseResult;
    }
}
