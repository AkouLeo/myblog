package com.cx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ChengXing
 * @Date Created in 21:11 2021/11/10
 * @Description 20211110blog
 */
@Controller
public class IndexController {
    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }
}
