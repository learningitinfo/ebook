package com.leshan.ebook.mapper;

import com.leshan.ebook.mybatis.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 获取所有分类
     * @return 分类集合
     */
    public List<Category> findAllCategories();

    /**
     * 添加分类
     * @param category
     * @return
     */
    public int addCategory(Category category);

    /**
     * 修改分类
     * @param category
     * @return
     */
    public int updateCategory(Category category);
}
