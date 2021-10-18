package com.leshan.ebook.controller;

import com.leshan.ebook.mybatis.entity.Category;
import com.leshan.ebook.service.CategoryService;
import com.leshan.ebook.utils.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Category> list(){
        return categoryService.findAllCategories();
    }

    /**
     * 以表单方式提交数据，参数直接写成实体对象
     * 以JSON方式提交数据，参数类型之前需要加@Requestbody
     * @param category
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResponseResult<Category> add(@RequestBody Category category){
        ResponseResult<Category> responseResult = new ResponseResult<>();
        categoryService.addCategory(category);
        responseResult.setCode(200);
        responseResult.setMessage("添加类别成功");
        responseResult.setData(category);
        return responseResult;

    }
}
