package com.leshan.ebook.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leshan.ebook.mapper.UserMapper;
import com.leshan.ebook.mybatis.entity.User;
import com.leshan.ebook.service.MailService;
import com.leshan.ebook.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    //注入mapper
    @Resource
    private UserMapper userMapper;

    @Resource
    private MailService mailService;

    @Override
    public User findByAccount(String account) {
        return userMapper.findByAccount(account);
    }


    @Override
    public PageInfo<User> getPageInfo(Integer pageNum, Integer pageSize) {
        //设置页码和每页记录数
        PageHelper.startPage(pageNum,pageSize);
        //获取用户集合
        List<User> list = userMapper.findAll();
        //创建PageInfo对象，将集合添加到该对象中
        PageInfo<User> pageInfo = new PageInfo<>(list);
        //返回该对象
        return pageInfo;
    }

    @Override
    public void addUser(User user) {
        //添加用户
        userMapper.addUser(user);
        //获取验证码（激活码）
        String code = user.getAvatar();
        //主题
        String subject = "来自蜗牛图书网的激活邮件";
        //user/checkCode?code=code(激活码)是我们点击邮件链接之后根据激活码查询用户，如果存在说明一致，将用户状态修改为“1”激活
        //上面的激活码发送到用户注册邮箱
        String context = "<a href='http://learningit.free.svipss.top/user/checkCode?code="+code+"'>激活请点击:"+code+"</a>";
        //发送激活邮件
        mailService.sendHtmlMail (user.getEmail(),subject,context);
    }

    @Override
    public User checkCode(String code) {
        return userMapper.findUserByAvatar(code);
    }

    @Override
    public void updateUserStatus(User user) {
        userMapper.updateUserStatus(user);
    }
}
