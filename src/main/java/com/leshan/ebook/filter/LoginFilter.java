package com.leshan.ebook.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leshan.ebook.enums.Status;
import com.leshan.ebook.utils.ResponseResult;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //1.得到uri
        HttpServletRequest servletRequest = (HttpServletRequest)request;
        String uri = servletRequest.getRequestURI();
        //System.out.println(uri);

        //2.判断该uri是否以/order   /cart开头，如果是则判断当前是否登录，否则直接放行
        if (uri.startsWith("/cart") || uri.startsWith("/order")){
            //得到session
            HttpSession session = servletRequest.getSession();
            //得到用户id
            Object userid  = session.getAttribute("userid");
            if (userid == null){
                //没登录
                ResponseResult responseResult = new ResponseResult();
                responseResult.setCode(500);
                responseResult.setStatus(Status.NO_LOGIN);
                responseResult.setMessage("您还没有登录，请先登录!");

                //将对象转换成JSON，并将结果返回给前端
                String json = new ObjectMapper().writeValueAsString(responseResult);
                //
                HttpServletResponse servletResponse = (HttpServletResponse)response;
                //设置响应头，告知浏览器返回的是JSON数据
                servletResponse.setContentType("application/json;charset=utf-8");
                //将数据返回
                servletResponse.getWriter().write(json);
                //
                return;   //让请求提前结束
            }
        }

        //放行：让其它过滤器、controller处理请求
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
