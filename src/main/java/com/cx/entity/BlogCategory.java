package com.cx.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author ChengXing
 * @Date Created in 22:20 2021/11/22
 * @Description 20211110blog
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("blog_category")
public class BlogCategory implements java.io.Serializable {
    @TableId(type = IdType.AUTO)
    // 主键
    private Integer id;
    // 分类标题
    private String categoryTitle;
    // 创建时间
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    // 更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    // 分类的发布状态 0 未发布 1 发布
    private Integer status;
    // 分类排序
    private Integer sorted;
}
