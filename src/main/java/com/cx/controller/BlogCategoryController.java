package com.cx.controller;

import com.cx.entity.BlogCategory;
import com.cx.service.IBlogCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ChengXing
 * @Date Created in 22:02 2021/11/30
 * @Description 20211110blog
 */
@RestController
@RequestMapping("/api/category")
public class BlogCategoryController {
    @Autowired
    private IBlogCategoryService blogCategoryService;


    /**
     * 加载分类数据
     *
     * @return
     */
    @RequestMapping("/load")
    public List<BlogCategory> findCategories() {
        return blogCategoryService.findBlogCategory();
    }
}
