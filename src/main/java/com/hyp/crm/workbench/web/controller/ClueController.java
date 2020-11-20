package com.hyp.crm.workbench.web.controller;

import com.hyp.crm.settings.domain.User;
import com.hyp.crm.settings.service.UserService;
import com.hyp.crm.settings.service.impl.UserServiceImpl;
import com.hyp.crm.utils.DateTimeUtil;
import com.hyp.crm.utils.PrintJson;
import com.hyp.crm.utils.ServiceFactory;
import com.hyp.crm.utils.UUIDUtil;
import com.hyp.crm.vo.PagenationVO;
import com.hyp.crm.workbench.domain.Activity;
import com.hyp.crm.workbench.domain.ActivityRemark;
import com.hyp.crm.workbench.service.ActivityService;
import com.hyp.crm.workbench.service.impl.ActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HYP
 * @create 2020-11-15 19:23
 */
public class ClueController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到线索控制器");

        String path = request.getServletPath();
        if ("/workbench/activity/xxx.do".equals(path)) {


        }
    }




}
