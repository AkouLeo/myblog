package com.cx.handler;

import com.cx.constants.BaseConstant;
import com.cx.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChengXing
 * @Date Created in 21:13 2021/12/7
 * @Description 20211110blog
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取用户登录的信息
        User user = (User) request.getSession().getAttribute(BaseConstant.SESSION_USER);
        // 如果已经登录 则重定向到首页
        if (user == null) {
            response.sendRedirect("/api/login/loginUser");
            return false;
        }
        // 如果拦截器执行返回完毕，返回为true，
        // 代表的是，执行完逻辑了，可以处理springmvc的路由方法了
        // 如果为false，直接阻断，不会处理任何动作（动作由在自己决定）
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("3333333333333=>postHandle执行进来了");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("4444444444444444=>afterCompletion执行进来了");

    }
}
