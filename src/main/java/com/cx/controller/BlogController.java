package com.cx.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.entity.Blog;
import com.cx.service.IBlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ChengXing
 * @Date Created in 21:50 2021/12/1
 * @Description 20211110blog
 */
@Controller
@RequestMapping("/api/blog")
@Slf4j
public class BlogController {
    @Autowired
    private IBlogService blogService;

    /**
     * 跳转到博客详情页面
     *
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView blogDetail() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("blog/detail");
        return modelAndView;
    }

    /**
     * 获得博客详细信息
     *
     * @return
     */
    @RequestMapping("getDetail")
    @ResponseBody
    public Blog findBlogDetail(Blog blog) {
        Integer id = blog.getId();
        Blog blogDetail = blogService.getById(id);
        return blogDetail;
    }

    /**
     * 查询博客内容信息
     *
     * @return
     */
    @GetMapping("/load")
    @ResponseBody
    public Page<Blog> findBlog(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
                               @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                               @RequestParam(required = false, defaultValue = "0") Integer categoryId) {
        // 设置分页
        Page page = new Page(pageNo, pageSize);
        // 增加条件
        LambdaQueryWrapper<Blog> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 查询条件发布status==1 未删除的 isdelete==0
        // 排序
        lambdaQueryWrapper
                .eq(categoryId != null && !categoryId.equals(0), Blog::getCategoryId, categoryId)
                .eq(Blog::getStatus, 1)
                .eq(Blog::getIsDelete, 0)
                .orderByDesc(Blog::getCreateTime);
        // 执行分页
        Page blogList = blogService.page(page, lambdaQueryWrapper);
        return blogList;
    }
}
