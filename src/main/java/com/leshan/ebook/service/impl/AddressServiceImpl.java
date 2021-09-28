package com.leshan.ebook.service.impl;

import com.leshan.ebook.mapper.AddressMapper;
import com.leshan.ebook.mybatis.entity.Address;
import com.leshan.ebook.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressMapper addressMapper;

    @Override
    public List<Address> findByUserId(int userid) {
        return addressMapper.findByUserId(userid);
    }
}
