package com.leshan.ebook.service;

import com.leshan.ebook.mybatis.entity.User;

public interface UserService {
    public User findByAccount(String account);
}
