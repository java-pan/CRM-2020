package com.hyp.crm.workbench.web.controller;

import com.hyp.crm.settings.domain.User;
import com.hyp.crm.settings.service.UserService;
import com.hyp.crm.settings.service.impl.UserServiceImpl;
import com.hyp.crm.utils.*;
import com.hyp.crm.vo.PagenationVO;
import com.hyp.crm.workbench.domain.Activity;
import com.hyp.crm.workbench.domain.ActivityRemark;
import com.hyp.crm.workbench.service.ActivityService;
import com.hyp.crm.workbench.service.impl.ActivityServiceImpl;
import org.apache.ibatis.annotations.Update;

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
public class ActivityController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到市场活动控制器");

        String path = request.getServletPath();
        if ("/workbench/activity/getUserList.do".equals(path)) {
            getUserList(request, response);

        } else if ("/workbench/activity/save.do".equals(path)) {
            save(request, response);

        } else if ("/workbench/activity/pageList.do".equals(path)) {
            pageList(request, response);
        }else if ("/workbench/activity/delete.do".equals(path)) {
            delete(request,response);
        } else if ("/workbench/activity/getUserListAndActivity.do".equals(path)) {
            getUserListAndActivity(request,response);
        }else if ("/workbench/activity/update.do".equals(path)) {
            update(request,response);
        }else if ("/workbench/activity/detail.do".equals(path)) {
            detail(request,response);
        }else if ("/workbench/activity/getRemarkListByAid.do".equals(path)) {

            getRemarkListByAid(request,response);
        }else if ("/workbench/activity/deleteRemark.do".equals(path)) {

            deleteRemark(request,response);
        }else if ("/workbench/activity/saveRemark.do".equals(path)) {
            saveRemark(request,response);
        }else if ("/workbench/activity/updateRemark.do".equals(path)) {
            updateRemark(request,response);
        }

    }

    private void updateRemark(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行修改备注的操作");

        String  editTime= DateTimeUtil.getSysTime();
        String editFlag = "1";

        String  editBy=((User)request.getSession().getAttribute("user")).getName();

        String id = request.getParameter("id");
        String noteContent = request.getParameter("noteContent");
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        ActivityRemark ar = new ActivityRemark();
        ar.setEditFlag(editFlag);
        ar.setEditBy(editBy);
        ar.setEditTime(editTime);
        ar.setId(id);
        ar.setNoteContent(noteContent);
        boolean flag = as.updateRemark(ar);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("success",flag);
        map.put("ar",ar);
        PrintJson.printJsonObj(response,map);




    }

    private void saveRemark(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行添加备注的操作");
        String noteContent = request.getParameter("noteContent");
        String activityId = request.getParameter("activityId");
        String id = UUIDUtil.getUUID();
        String  createTime= DateTimeUtil.getSysTime();
        String  createBy=((User)request.getSession().getAttribute("user")).getName();
        String editFlag = "0";
        ActivityRemark ar = new ActivityRemark();
        ar.setId(id);
        ar.setNoteContent(noteContent);
        ar.setActivityId(activityId);
        ar.setCreateBy(createBy);
        ar.setCreateTime(createTime);
        ar.setEditFlag(editFlag);
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        boolean flag = as.saveRemark(ar);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("success",flag);
        map.put("ar",ar);
        PrintJson.printJsonObj(response,map);

    }

    private void deleteRemark(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入删除备注信息方法");
        String id = request.getParameter("id");
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        boolean flag = as.deleteRemark(id);
        PrintJson.printJsonFlag(response,flag);

    }

    private void getRemarkListByAid(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("根据市场活动id，取得备注信息列表");
        String activityId = request.getParameter("activityId");
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        List<ActivityRemark> arList=as.getRemarkListByAid(activityId);
        PrintJson.printJsonObj(response,arList);



    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到跳转到详细信息页的操作");
        String id = request.getParameter("id");
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        Activity a = as.detail(id);
        request.setAttribute("a",a);
        request.getRequestDispatcher("/workbench/activity/detail.jsp").forward(request,response);


    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行市场活动修改操作");
        String id = request.getParameter("id");
        String owner = request.getParameter("owner");
        String name = request.getParameter("name");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String cost = request.getParameter("cost");
        String description = request.getParameter("description");
        //修改时间，当前系统时间
        String editTime = DateTimeUtil.getSysTime();
        //修改人，当前登录用户
        String editBy = ((User) request.getSession().getAttribute("user")).getName();

        Activity a = new Activity();
        a.setId(id);
        a.setCost(cost);
        a.setStartDate(startDate);
        a.setOwner(owner);
        a.setName(name);
        a.setEndDate(endDate);
        a.setDescription(description);
        a.setCreateTime(editTime);
        a.setCreateBy(editBy);


        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        boolean flag = as.update(a);
        PrintJson.printJsonFlag(response, flag);


    }

    private void getUserListAndActivity(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入到查询用户信息列表和根据市场活动id查询单条记录的操作");
        String id = request.getParameter("id");
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        /*
        * 往前端返回的是用户列表和市场活动，所以要往前端传一个map
        *
        * 总结：
        *       controller调用service的方法，返回值应该是什么
        *           你得想一想前端要什么，就要从service层取什么
        *
        * */
              Map<String,Object> map =as.getUserListAndActivity(id);
              PrintJson.printJsonObj(response,map);




    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行市场活动的删除操作");
        String[] ids = request.getParameterValues("id");
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
       boolean flag =  as.delete(ids);
       PrintJson.printJsonFlag(response,flag);

    }

    private void pageList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入了pageList方法");
        String name = request.getParameter("name");
        String owner = request.getParameter("owner");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        //页码
        String pageNoStr = request.getParameter("pageNo");
        int pageNo = Integer.valueOf(pageNoStr);
        //每页展现的记录数
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize = Integer.valueOf(pageSizeStr);
        /*
         * MySQL数据库中limit后面的两个参数分别代表
         *           select * from tbl_student limit 0,5;
         *            第一个参数表示，要略过的记录数。
         *            第二个参数表示，每页展示的记录数
         *
         * */
        //由页码和每页展示的记录数，求出第一个参数，也即是要略过的记录数
        int skipCount = (pageNo - 1) * pageSize;
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("owner", owner);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("skipCount", skipCount);
        map.put("pageSize", pageSize);
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        /*
        *
            前端要的数据:
            *    市场活动信息列表
                 查询的总条数
            业务层拿到了以上两项信息之后，如何选择合适的方式做返回？
            * 1、 map:
                map.put( "dataList" : datalist)
            *   map .put( "total" :total)
                PrintJSON map --> json
                     { "total" :180 , "dataList":[{市场活动1},{2},{3}]}
            2、vo:推荐vo因为重用率高
                 PaginationVO<T>，创建一个带泛型的类
                 private int total;
                 private List<T> datalist;
                 pagenationVO<activity> vo = new pagenationVo<>();
                 * vo.setTotal(total);
                 * vo.setDataList(dataList);
                 * PrintJSON vo --> json
                 *      { "total" :180 , "dataList":[{市场活动1},{2},{3}]}
                 *
                 * 将来分页查询，每个模块都有，所以我们选择使用一个通用的vo,操作起来比较方便
                 *

        *
        *
        * */
        PagenationVO<Activity> vo = as.pageList(map);
        PrintJson.printJsonObj(response,vo);


    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        String id = UUIDUtil.getUUID();
        String owner = request.getParameter("owner");
        String name = request.getParameter("name");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String cost = request.getParameter("cost");
        String description = request.getParameter("description");
        //创建时间，当前系统时间
        String createTime = DateTimeUtil.getSysTime();
        //创建人，当前登录用户
        String createBy = ((User) request.getSession().getAttribute("user")).getName();

        Activity a = new Activity();
        a.setId(id);
        a.setCost(cost);
        a.setStartDate(startDate);
        a.setOwner(owner);
        a.setName(name);
        a.setEndDate(endDate);
        a.setDescription(description);
        a.setCreateTime(createTime);
        a.setCreateBy(createBy);


        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        boolean flag = as.save(a);
        PrintJson.printJsonFlag(response, flag);

    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        List<User> uList = us.getUserList();
        PrintJson.printJsonObj(response, uList);


    }


}
