package com.itheima.config;


import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterContextConfig {


    @Bean
    public FilterRegistrationBean sentienlFilterRegister(){

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CommonFilter());
        registration.addUrlPatterns("/*");
        //入口资源关闭聚和
        registration.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY,"false");
        registration.setName("sentinelFilter");
        registration.setOrder(1);

        return registration;
    }
}
