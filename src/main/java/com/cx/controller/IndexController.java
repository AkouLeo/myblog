package com.cx.controller;

import com.cx.constants.BaseConstant;
import com.cx.entity.User;
import com.cx.service.IBlogCategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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

//    @GetMapping(value = {"/", "/index"})
//    public String index(ModelMap modelMap) {
//        List<BlogCategory> blogCategories = blogCategoryService.findBlogCategory();
//        // 把查询的分类放到数据模型中
//        modelMap.addAttribute("blogCategories", blogCategories);
//        //
//        return "index";
//    }

    @GetMapping(value = {"/", "/index"})
    public ModelAndView newIndex(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        // 获取用户登录的信息
        User user = (User) session.getAttribute(BaseConstant.SESSION_USER);
        // 如果已经登录 则重定向到首页
        if (user == null) {
            modelAndView.setViewName("redirect:/api/login/loginUser");
            return modelAndView;
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
