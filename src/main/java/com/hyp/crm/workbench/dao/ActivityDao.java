package com.hyp.crm.workbench.dao;


import com.hyp.crm.vo.PagenationVO;
import com.hyp.crm.workbench.domain.Activity;

import java.util.List;
import java.util.Map;

/**
 * @author HYP
 * @create 2020-11-16 17:31
 */
public interface ActivityDao {
     int save(Activity a);

    int getTotalByCondition(Map<String, Object> map);

    List<Activity> getActivityListByCondition(Map<String, Object> map);


    int delete(String[] ids);


    Activity getById(String id);

    int update(Activity a);

    Activity detail(String id);
}
