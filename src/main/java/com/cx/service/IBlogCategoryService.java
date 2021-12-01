package com.cx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.entity.BlogCategory;

import java.util.List;

/**
 * @author ChengXing
 * @Date Created in 22:22 2021/11/22
 * @Description 20211110blog
 */
public interface IBlogCategoryService extends IService<BlogCategory> {
    /**
     * 查询首页分类
     * @return
     */
    List<BlogCategory> findBlogCategory();
}
