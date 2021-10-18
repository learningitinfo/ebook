package com.leshan.ebook.service;

import com.github.pagehelper.PageInfo;
import com.leshan.ebook.mybatis.entity.User;

public interface UserService {
    /**
     * 根据登录获取用户对象
     * @param account 登录名称
     * @return 用户对象
     */
    public User findByAccount(String account);

    /**
     * 获取PageInfo对象
     * @param pageNum 页码
     * @param pageSize 每页的记录数
     * @return PageInfo对象
     */
    public PageInfo<User> getPageInfo(Integer pageNum,Integer pageSize);

    /**
     * 添加用户
     * @param user 用户对象
     */
    public void addUser(User user);

    /**
     * 根据验证码来获取用户
     * @param code 验证码（头像）
     * @return 用户对象
     */
    public User checkCode(String code);

    /**
     * 修改用户状态
     * @param user 对象对象
     */
    public void updateUserStatus(User user);
}
