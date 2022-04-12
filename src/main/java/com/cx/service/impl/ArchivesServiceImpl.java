package com.cx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cx.entity.Blog;
import com.cx.service.IArchivesService;
import com.cx.service.IBlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author ChengXing
 * @Date Created in 21:21 2021/12/9
 * @Description 20211110blog
 */
@Service
@Slf4j
public class ArchivesServiceImpl implements IArchivesService {
    @Autowired
    private IBlogService blogService;

    @Override
    public Map<Integer, List<Blog>> queryBlog() {
        LambdaQueryWrapper<Blog> queryWrapper = new LambdaQueryWrapper<>();
        // 查询条件
        queryWrapper.eq(Blog::getStatus, 1);
        queryWrapper.select(Blog.class, s -> !s.getColumn().equals("content"));
        // 查询所有的博客内容
        List<Blog> list = blogService.list(queryWrapper);
        // 使用stream流的分组功能进行数据处理
        TreeMap<Integer, List<Blog>> collect1 = new TreeMap<>((o2, o1) -> o1 - o2);
        TreeMap<Integer, List<Blog>> collect2 = list.stream().
                collect(Collectors.groupingBy(blog -> blog.getCreateTime().getYear(), TreeMap::new, Collectors.toList()));

        for (Map.Entry<Integer, List<Blog>> integerListEntry : collect2.entrySet()) {
            collect1.put(integerListEntry.getKey(), integerListEntry.getValue());
        }

        return collect1;
    }
}
