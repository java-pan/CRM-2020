package com.hyp.crm.settings.web.controller;

import com.hyp.crm.settings.domain.User;
import com.hyp.crm.settings.service.UserService;
import com.hyp.crm.settings.service.impl.UserServiceImpl;
import com.hyp.crm.utils.MD5Util;
import com.hyp.crm.utils.PrintJson;
import com.hyp.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HYP
 * @create 2020-11-15 19:23
 */
public class UserController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        if ("/settings/user/login.do".equals(path)){
            login(request,response);

        }else if ("/settings/user/xxx.do".equals(path)){

        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) {

        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        loginPwd = MD5Util.getMD5(loginPwd);
        String ip = request.getRemoteAddr();



        //未来业务层开发，统一使用代理类形态的接口对象
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());

        try {
            User user = us.login(loginAct,loginPwd,ip);
            request.getSession().setAttribute("user",user);
            //如果程序执行到此处，说明业务层没有为controller抛出任何的异常
            //表示登录成功
            PrintJson.printJsonFlag(response,true);
        }catch (Exception e){
            e.printStackTrace();
            //一旦程序执行了catch块的信息，说明业务层为我们验证登录失败，为controller抛出了异常
            //表示登录失败
            String msg = e.getMessage();
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("success",false);
            map.put("msg",msg);
            PrintJson.printJsonObj(response,map);

        }




    }
}
