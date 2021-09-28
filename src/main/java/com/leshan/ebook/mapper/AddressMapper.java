package com.leshan.ebook.mapper;

import com.leshan.ebook.mybatis.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    //通过用户id查询出该用户的所有收货地址
    public List<Address> findByUserId(int userid);

    //通过地址id查询地址信息
    public Address findById(int id);
}
