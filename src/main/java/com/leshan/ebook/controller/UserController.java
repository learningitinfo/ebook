package com.leshan.ebook.controller;

import com.github.pagehelper.PageInfo;
import com.leshan.ebook.enums.Status;
import com.leshan.ebook.mybatis.entity.User;
import com.leshan.ebook.service.UserService;
import com.leshan.ebook.utils.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

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
            if (pwd.equals(user.getPassword())&&(user.getStatus().equals("1"))){
                //账号密码都对，表示登录成功
                System.out.println("登录成功!");

                //将用户的id存放到session中，表示用户登录了
                session.setAttribute("userid",user.getId());

                //设置返回的数据
                responseResult.setCode(200);
                responseResult.setStatus(Status.LOGIN_SUCCESS);
                responseResult.setMessage("登录成功");
                responseResult.setData(user);
                //
                return responseResult;
            }
        }

        System.out.println("登录失败");
        responseResult.setCode(500);
        responseResult.setStatus(Status.LOGIN_FAIL);
        responseResult.setMessage("账号、密码有误或该账号没有激活，请查看邮箱!");
        //
        return responseResult;
    }

    @RequestMapping("/getPageInfo")
    @ResponseBody
    public PageInfo<User> getPageInfo(@RequestParam(value="pageNum",required = false,defaultValue = "1")Integer pageNum,
                                      @RequestParam(value="pageSize",required = false,defaultValue = "4")Integer pageSize){
         return userService.getPageInfo(pageNum,pageSize);
    }

    /**
     * 用户注册
     * @param user 用户对象
     * @return
     */
    @RequestMapping(value = "/register")
    @ResponseBody
    public ResponseResult register(User user){
        user.setStatus("0");
        user.setRegtime(new Date());
        //生成验证码（激活码--头像）
        String code = UUID.randomUUID().toString().replaceAll("-","");
        //设置用户头像为激活码，后期会上传用户头像
        user.setAvatar(code);
        userService.addUser(user);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setMessage("注册成功,请通过邮箱激活！");
        responseResult.setStatus(Status.LOGIN_SUCCESS);
        responseResult.setData(user);
        responseResult.setCode(200);
        return responseResult;
    }

    /**
     *校验邮箱中的code激活账户
     * 首先根据激活码code查询用户，之后再把状态修改为"1"
     */
    @RequestMapping(value = "/checkCode")
    public String checkCode(String code){
        //根据激活码获取用户对象
        User user = userService.checkCode(code);
        //如果用户不等于null，把用户状态修改status=1
        if (user !=null){
            user.setStatus("1");
            //把code验证码清空，已经不需要了
            user.setAvatar(null);
            //更新用户
            userService.updateUserStatus(user);
        }
        return "redirect:/login.html";
    }
}
