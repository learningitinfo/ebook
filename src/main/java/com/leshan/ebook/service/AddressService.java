package com.leshan.ebook.service;

import com.leshan.ebook.mybatis.entity.Address;

import java.util.List;

public interface AddressService {
    public List<Address> findByUserId(int userid);
}
