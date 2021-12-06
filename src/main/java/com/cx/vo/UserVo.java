package com.cx.vo;

import lombok.Data;

/**
 * @author ChengXing
 * @Date Created in 21:28 2021/12/6
 * @Description 20211110blog
 */
@Data
public class UserVo {
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证码
     */
    private String code;
}
