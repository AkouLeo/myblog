package com.cx.controller;

import com.cx.entity.Blog;
import com.cx.service.IArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author ChengXing
 * @Date Created in 20:53 2021/12/9
 * @Description 20211110blog
 */
@Controller
@RequestMapping("api/archives")
public class ArchivesController {

    @Autowired
    private IArchivesService archivesService;

    /**
     * @return
     */
    @GetMapping("/index")
    public ModelAndView toArchives() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("archives/archives");
        return modelAndView;
    }

    /**
     * 查询文章归档数据
     *
     * @return
     */
    @GetMapping("/load")
    @ResponseBody
    public Map<Integer, List<Blog>> queryBlogs() {
        Map<Integer, List<Blog>> blogs = archivesService.queryBlog();
        return blogs;
    }
}
