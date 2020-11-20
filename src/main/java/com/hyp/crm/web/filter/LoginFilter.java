package com.hyp.crm.web.filter;

import com.hyp.crm.settings.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HYP
 * @create 2020-11-16 15:37
 */
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //过滤器，验证用户是否登录过，如果没有则跳回登录页面
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;

        String path = request1.getServletPath();
        //不应该被拦截的资源，自动放行请求
        if ("/login.jsp".equals(path)||"/settings/user/login.do".equals(path)){
            chain.doFilter(request,response);
            //其他资源必须验证有没有登录过
        }else {

            if (request1.getSession().getAttribute("user")==null){
                response1.sendRedirect(request1.getContextPath()+"/login.jsp");
            }else {
                chain.doFilter(request,response);
            }
        }




    }
}
