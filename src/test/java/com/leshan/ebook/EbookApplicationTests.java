package com.leshan.ebook;

import com.leshan.ebook.mapper.GoodsMapper;
import com.leshan.ebook.mybatis.entity.Goods;
import com.leshan.ebook.mybatis.entity.dto.GoodsDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class EbookApplicationTests {

    //Autoward：首先以名字的方式获得对象，如果通过名字得不到再通过类型得到
    //Resource：首先以类型得到对象，如果得不到再以名字得到

    @Resource
    private GoodsMapper goodsMapper;

    @Test
    void contextLoads() {
        //编写测试代码
        Goods goods = goodsMapper.findById(10);
        //
        System.out.println(goods);
    }

    @Test
    void findNewSetTest(){
        List<GoodsDto> goodsList = goodsMapper.findNewSet();
        for(GoodsDto goods : goodsList){
            System.out.println(goods);
        }
    }

    @Test
    void findHotTest(){
        List<GoodsDto> goodsList = goodsMapper.findHot();
        System.out.println(goodsList);
    }

}
