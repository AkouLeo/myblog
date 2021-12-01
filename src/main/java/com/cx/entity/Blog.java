package com.cx.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author ChengXing
 * @Date Created in 21:43 2021/12/1
 * @Description 20211110blog
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("blog")
public class Blog implements java.io.Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    // 内容标题
    private String title;
    // 分类内容
    private String content;
    // 分类id
    private Integer categoryId;
    // 分类名称
    private String categoryTitle;
    // 内容封面
    private String img;
    // 添加用户
    private Integer userId;
    // 创建时间
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    // 更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    // 发布状态 0未发布  1发布
    private Integer status;
    // 删除状态 0未删除 1删除
    @TableLogic(value = "0", delval = "1")
    private Integer isDelete;
}
