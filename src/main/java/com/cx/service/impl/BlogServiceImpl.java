package com.cx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.entity.BlogCategory;
import com.cx.mapper.BlogCategoryMapper;
import com.cx.service.IBlogCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ChengXing
 * @Date Created in 22:28 2021/11/22
 * @Description 20211110blog
 */
@Service
@Slf4j
public class BlogServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements IBlogCategoryService {
}
