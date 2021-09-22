package com.leshan.ebook.controller;

import com.leshan.ebook.enums.Status;
import com.leshan.ebook.mybatis.entity.User;
import com.leshan.ebook.service.UserService;
import com.leshan.ebook.utils.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //在controller方法的参数列表中，可以指定多个参数，用于接收不同的数据，但是要注意：形参的名字
    //需要与前端对应的参数名相同
    //如果在controller的方法上需要request、response、session、context对象，只需要在参数列表指定对应的参数
    //然后springboot会自动将对应的对象传递给该方法，那么在方法中直接拿来用即可
    @RequestMapping("/login")
    @ResponseBody
    public ResponseResult login(String account, String pwd, HttpSession session){
        //打印：测试是否能够正常获取到账号、密码
        System.out.println(account+","+pwd);

        //思路：通过账号作为查询条件，到数据库查询用户信息，如果查询到的结果为null表示账号不存在
        //如果能够查询到结果，说明账号是存在的，然后用查询出的密码与用户提交的密码进行比对，如果
        //密码一致，说明账号密码都正确，即登录成功
        User user = userService.findByAccount(account);
        //
        ResponseResult responseResult = new ResponseResult();
        //判断
        if (user != null){
            //判断密码
            if (pwd.equals(user.getPassword())){
                //账号密码都对，表示登录成功
                System.out.println("登录成功!");

                //将用户的id存放到session中，表示用户登录了
                session.setAttribute("userid",user.getId());

                //设置返回的数据
                responseResult.setCode(200);
                responseResult.setStatus(Status.LOGIN_SUCCESS);
                responseResult.setMessage("登录成功");
                //
                return responseResult;
            }
        }

        System.out.println("登录失败");
        responseResult.setCode(500);
        responseResult.setStatus(Status.LOGIN_FAIL);
        responseResult.setMessage("账号或密码有误!");
        //
        return responseResult;
    }
}
