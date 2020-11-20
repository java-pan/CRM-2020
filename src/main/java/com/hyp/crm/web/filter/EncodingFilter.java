package com.hyp.crm.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author HYP
 * @create 2020-11-16 14:04
 */
public class EncodingFilter  implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //过滤post请求中文参数乱码
         request.setCharacterEncoding("UTF-8");
        //过滤响应流响应中文乱码
        response.setContentType("text/html;charset=utf-8");
        //将请求放行
        chain.doFilter(request,response);

    }
}
