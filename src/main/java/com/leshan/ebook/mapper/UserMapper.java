package com.leshan.ebook.mapper;

import com.leshan.ebook.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //通过账号查询用户信息
    public User findByAccount(String account);
}
