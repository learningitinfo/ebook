package com.leshan.ebook.service;

import com.leshan.ebook.mybatis.entity.Category;

import java.util.List;

public interface CategoryService {
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
