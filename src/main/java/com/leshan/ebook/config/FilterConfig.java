package com.leshan.ebook.config;

import com.leshan.ebook.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration   //指定当前类是一个配置类
public class FilterConfig {
    //注册过滤器
    @Bean
    public FilterRegistrationBean reistFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        //添加过滤器
        bean.setFilter(new LoginFilter());
        //指定该filter过滤哪些请求
        bean.addUrlPatterns("/*");
        //指定执行的顺序
        bean.setOrder(1);
        //
        return bean;
    }
}
