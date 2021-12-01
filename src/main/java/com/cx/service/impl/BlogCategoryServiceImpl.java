package com.cx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.constants.BaseEnum;
import com.cx.entity.BlogCategory;
import com.cx.mapper.BlogCategoryMapper;
import com.cx.service.IBlogCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ChengXing
 * @Date Created in 22:28 2021/11/22
 * @Description 20211110blog
 */
@Service
@Slf4j
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements IBlogCategoryService {

    @Override
    public List<BlogCategory> findBlogCategory() {
        // 设置查询条件
        LambdaQueryWrapper<BlogCategory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BlogCategory::getStatus, BaseEnum.NORMAL.getCode());
//        queryWrapper.orderByAsc("sorted");
        // 查询所有的分类信息
        List<BlogCategory> blogCategories = this.list(queryWrapper);
        if (CollectionUtils.isEmpty(blogCategories)) {
            // stream流优化排序 可以提升性能
            blogCategories = blogCategories.stream()
                    .sorted((a, b) -> a.getSorted() - b.getSorted())
                    .collect(Collectors.toList());
        }
        return blogCategories;
    }
}
