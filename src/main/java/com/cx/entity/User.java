package com.cx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ChengXing
 * @Date Created in 21:29 2021/11/17
 * @Description 20211110blog
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("user")
public class User implements java.io.Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户收集
     */
    private String phone;
    /**
     * 用户的邮箱
     */
    private String email;
    /**
     * 用户的头像
     */
    private String avatar;
    /**
     * 用户的签名
     */
    private String sign;
    /**
     * 用户的注册时间
     */
    private Date createTime;
    /**
     * 用户的更新时间
     */
    private Date updateTime;
    /**
     * 用户的激活状态 1激活 0 未激活
     */
    private Integer active;
    /**
     * 角色 admin 管理员 normal正常用户
     */
    private String role;

}
