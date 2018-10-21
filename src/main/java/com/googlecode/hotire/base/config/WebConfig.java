package com.googlecode.hotire.base.config;

import com.googlecode.hotire.base.interceptor.LogInInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/login"); //로그인 쪽은 예외처리를 한다.
    }
}
