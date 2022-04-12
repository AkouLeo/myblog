package com.cx.service;

import com.cx.entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author ChengXing
 * @Date Created in 21:21 2021/12/9
 * @Description 20211110blog
 */
public interface IArchivesService {

    /**
     * 查询内容信息并分组
     */
    Map<Integer, List<Blog>> queryBlog();
}
