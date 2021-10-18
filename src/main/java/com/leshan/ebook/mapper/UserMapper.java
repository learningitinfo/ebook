package com.leshan.ebook.mapper;

import com.leshan.ebook.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //通过账号查询用户信息
    public User findByAccount(String account);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();

    /**
     * 添加用户
     * @param user 用户对象
     * @return
     */
    public void addUser(User user);

    /**
     * 修改用户状态
     * @param user
     */
    public void updateUserStatus(User user);

    /**
     * 注册时使用
     * 根据用户验证码（头像）获取用户对象
     * @param avater 验证码（头像）
     * @return 用户对象
     */
    public User findUserByAvatar(String avatar);

}
