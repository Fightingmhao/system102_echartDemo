package com.rayootech.config;

import com.rayootech.interceptor.UserLoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置拦截器
 * Created by FightingHao on 2020/3/5
 */
//配置拦截器
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {



    /**
     * 将自定义拦截器作为Bean写入配置
     * @return
     */
    @Bean
    public HandlerInterceptor getUserLoginInterceptor(){
        return new UserLoginInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {//
        registry.addInterceptor(getUserLoginInterceptor())//注册拦截器
                .addPathPatterns("/**")//默认对所有的Url进行拦截
                .excludePathPatterns("/user/login",
                        "/index.html",
                        "/static/**",
                        "/imgs/**",
                        "/pdf/**",
                        "favicon.ico");//除了这几个标注的

    }





}
