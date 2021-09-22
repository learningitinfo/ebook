package com.leshan.ebook.service.impl;

import com.leshan.ebook.mapper.UserMapper;
import com.leshan.ebook.mybatis.entity.User;
import com.leshan.ebook.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    //注入mapper
    @Resource
    private UserMapper userMapper;

    @Override
    public User findByAccount(String account) {
        return userMapper.findByAccount(account);
    }
}
