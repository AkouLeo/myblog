package com.cx.config;

import com.cx.handler.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ChengXing
 * @Date Created in 21:26 2021/12/7
 * @Description 20211110blog
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    /**
     * 初始化拦截器让springmvc去加载和装配
     *
     * @return
     */
    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    /**
     * 注册拦截器的方法
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        registry.addInterceptor(loginInterceptor())
                // 拦截器进入的路由规则
                // addPathPatterns代表以下配置的路由都会被拦截
                .addPathPatterns("/api/**", "/", "/index")
                .excludePathPatterns("/api/login/**");
    }
}
