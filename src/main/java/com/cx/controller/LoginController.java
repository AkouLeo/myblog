package com.cx.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cx.constants.BaseConstant;
import com.cx.entity.User;
import com.cx.service.IUserService;
import com.cx.utils.MD5.MD5Utils;
import com.cx.vo.UserVo;
import com.google.code.kaptcha.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author ChengXing
 * @Date Created in 14:59 2021/12/4
 * @Description 20211110blog
 */
@Controller
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private IUserService userService;

    /**
     * 跳转登录页面
     *
     * @return
     */
    @GetMapping("/loginUser")
    public String login(HttpSession session) {
//        // 获取用户登录的信息
//        User user = (User) session.getAttribute(BaseConstant.SESSION_USER);
//        // 如果已经登录 则重定向到首页
//        if (user != null) {
//            return "redirect:/";
//        }
        return "login";
    }

    /**
     * 推出
     *
     * @return
     */
    @GetMapping("/loginOut")
    public String loginOut(HttpSession session) {
        session.invalidate();
        return "redirect:/api/login/loginUser";
    }

    @PostMapping("/logined")
    @ResponseBody
    public String logined(@RequestBody UserVo userVo, HttpSession session) {
        // 根据账号查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone, userVo.getAccount());
        User user = userService.getOne(queryWrapper);
        // 如果用户不存在直接抛异常
        if (user == null) {
            return "fail";
        }

        // 比较验证码
        String code = userVo.getCode();
        if (code == null) {
            return "fail";
        }

        String sessionCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (!code.equalsIgnoreCase(sessionCode)) {
            return "falicode";
        }

        // MD5加密
        String password = MD5Utils.md5slat(userVo.getPassword());
        if (user.getPassword().equals(password)) {
            session.setAttribute(BaseConstant.SESSION_USER, user);
            return "success";
        }
        return "fail";
    }
}
