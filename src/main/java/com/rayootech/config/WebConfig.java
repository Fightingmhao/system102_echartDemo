package com.rayootech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/9 14:22
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 基于Servlet的全局配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST","GET","PUT","DELETE")
                .maxAge(1800)
                .allowCredentials(true)
                .allowedHeaders("*")
                .exposedHeaders("x-token");
    }
}

