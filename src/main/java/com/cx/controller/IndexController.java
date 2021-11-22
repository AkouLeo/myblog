package com.cx.controller;

import com.cx.entity.BlogCategory;
import com.cx.service.IBlogCategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author ChengXing
 * @Date Created in 21:11 2021/11/10
 * @Description 20211110blog
 */
@Controller
@Log4j2
public class IndexController {

    @Autowired
    private IBlogCategoryService blogCategoryService;

    @GetMapping(value = {"/", "/index"})
    public String index(ModelMap modelMap) {
        // 查询所有的分类信息
        List<BlogCategory> blogCategories = blogCategoryService.list();
        // 把查询的分类放到数据模型中
        modelMap.addAttribute("blogCategories", blogCategories);
        //
        return "index";
    }
}
