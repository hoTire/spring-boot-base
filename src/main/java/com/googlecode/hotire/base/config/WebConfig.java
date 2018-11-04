package com.googlecode.hotire.base.config;

import com.googlecode.hotire.base.filter.BaseFilter;
import com.googlecode.hotire.base.interceptor.LogInInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/login"); //로그인 쪽은 예외처리를 한다.
    }

    @Bean
    public FilterRegistrationBean<Filter> loggingFilter(){
        FilterRegistrationBean<Filter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new BaseFilter());
        registrationBean.addUrlPatterns("/filter","/test/filter");

        return registrationBean;
    }

}
