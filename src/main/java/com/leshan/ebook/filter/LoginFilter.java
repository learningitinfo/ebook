package com.leshan.ebook.filter;

import javax.servlet.*;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("过滤器进行请求过滤");

        //放行：让其它过滤器、controller处理请求
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
