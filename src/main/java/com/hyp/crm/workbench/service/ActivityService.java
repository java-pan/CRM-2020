package com.hyp.crm.workbench.service;

import com.hyp.crm.vo.PagenationVO;
import com.hyp.crm.workbench.domain.Activity;
import com.hyp.crm.workbench.domain.ActivityRemark;

import java.util.List;
import java.util.Map;

/**
 * @author HYP
 * @create 2020-11-16 17:37
 */
public interface ActivityService {
    boolean save(Activity a);

    PagenationVO<Activity> pageList(Map<String, Object> map);


    boolean delete(String[] ids);

    Map<String, Object> getUserListAndActivity(String id);

    boolean update(Activity a);

    Activity detail(String id);

    List<ActivityRemark> getRemarkListByAid(String activityId);

    boolean deleteRemark(String id);

    boolean saveRemark(ActivityRemark ar);

    boolean updateRemark(ActivityRemark ar);
}
