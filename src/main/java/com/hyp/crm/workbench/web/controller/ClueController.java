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
import com.hyp.crm.workbench.domain.Clue;
import com.hyp.crm.workbench.service.ActivityService;
import com.hyp.crm.workbench.service.ClueService;
import com.hyp.crm.workbench.service.impl.ActivityServiceImpl;
import com.hyp.crm.workbench.service.impl.ClueServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.Detail;
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
        if ("/workbench/clue/getUserList.do".equals(path)) {
            getUserList(request,response);
        }else if ("/workbench/clue/save.do".equals(path)){
            save(request,response);
        }else if ("/workbench/clue/detail.do".equals(path)){
            detail(request,response);
        }else if ("/workbench/clue/getActivityListByClueId.do".equals(path)){
            getActivityListByClueId(request,response);
        }else if ("/workbench/clue/deleteActivityById.do".equals(path)){
            deleteActivityById(request,response);
        }else if ("/workbench/clue/getActivityListByNameAndNotByClueId.do".equals(path)){
            getActivityListByNameAndNotByClueId(request,response);
        }else if ("/workbench/clue/bund.do".equals(path)){
            bund(request,response);
        }
    }

    private void bund(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入关联市场活动的参数");
        String cid = request.getParameter("cid");
        String aids[] = request.getParameterValues("aid");
        ClueService cs = (ClueService) ServiceFactory.getService(new ClueServiceImpl());
        boolean flag = cs.bund(cid,aids);
        PrintJson.printJsonFlag(response,flag);

    }

    private void getActivityListByNameAndNotByClueId(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("查询市场活动列表(根据名称模糊查+排除已经关联指定线索的列表)");
        String clueId = request.getParameter("clueId");
        String aname = request.getParameter("aname");
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("clueId",clueId);
        map.put("aname",aname);
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        List<Activity> aList = as.getActivityListByNameAndNotByClueId(map);
        PrintJson.printJsonObj(response,aList);


    }

    private void deleteActivityById(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入解除关联的方法");
        String id = request.getParameter("id");
        ClueService cs = (ClueService) ServiceFactory.getService(new ClueServiceImpl());
        boolean flag = cs.deleteActivityById(id);
        PrintJson.printJsonFlag(response,flag);

    }

    private void getActivityListByClueId(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("根据线索id查询市场活动的方法");
        String clueId = request.getParameter("clueId");
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        List<Activity> aList= as.getActivityListByClueId(clueId);
         PrintJson.printJsonObj(response,aList);


    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("跳转到线索的详细信息页的方法");
        String id = request.getParameter("id");
        ClueService cs = (ClueService) ServiceFactory.getService(new ClueServiceImpl());
        Clue c = cs.detail(id);
        request.setAttribute("c",c);
        request.getRequestDispatcher("/workbench/clue/detail.jsp").forward(request,response);




    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入添加线索的方法");

       String id = UUIDUtil.getUUID();
       String fullname=request.getParameter("fullname");
       String appellation=request.getParameter("appellation");
       String owner=request.getParameter("owner");
       String company=request.getParameter("company");
       String job=request.getParameter("job");
       String email=request.getParameter("email");
       String phone=request.getParameter("phone");
       String website=request.getParameter("website");
       String mphone=request.getParameter("mphone");
       String state=request.getParameter("state");
       String source=request.getParameter("source");
       String createBy=((User)request.getSession().getAttribute("user")).getName();
       String createTime=DateTimeUtil.getSysTime();
       String description=request.getParameter("description");
       String contactSummary=request.getParameter("contactSummary");
       String nextContactTime=request.getParameter("nextContactTime");
       String address=request.getParameter("address");
        Clue c = new Clue();
        c.setId(id);
        c.setFullname(fullname);
        c.setAppellation(appellation);
        c.setOwner(owner);
        c.setCompany(company);
        c.setJob(job);
        c.setEmail(email);
        c.setPhone(phone);
        c.setWebsite(website);
        c.setMphone(mphone);
        c.setState(state);
        c.setSource(source);
        c.setCreateBy(createBy);
        c.setCreateTime(createTime);
        c.setDescription(description);
        c.setContactSummary(contactSummary);
        c.setNextContactTime(nextContactTime);
        c.setAddress(address);
        ClueService cs = (ClueService) ServiceFactory.getService(new ClueServiceImpl());
        boolean flag = cs.save(c);
        PrintJson.printJsonFlag(response,flag);



    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("取得用户信息列表");
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        List<User> uList = us.getUserList();
        PrintJson.printJsonObj(response,uList);

    }


}
