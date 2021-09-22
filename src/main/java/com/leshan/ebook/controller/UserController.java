package com.leshan.ebook.controller;

import com.leshan.ebook.utils.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    @ResponseBody
    //在controller方法的参数列表中，可以指定多个参数，用于接收不同的数据，但是要注意：形参的名字
    //需要与前端对应的参数名相同
    public ResponseResult login(String account,String pwd){
        //打印：测试是否能够正常获取到账号、密码
        System.out.println(account+","+pwd);
        return null;
    }
}
