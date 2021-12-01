package com.cx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.entity.Blog;
import com.cx.mapper.BlogMapper;
import com.cx.service.IBlogService;
import org.springframework.stereotype.Service;

/**
 * @author ChengXing
 * @Date Created in 21:49 2021/12/1
 * @Description 20211110blog
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {
}
