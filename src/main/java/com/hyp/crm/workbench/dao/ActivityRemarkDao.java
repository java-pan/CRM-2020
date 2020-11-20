package com.hyp.crm.workbench.dao;

import com.hyp.crm.workbench.domain.ActivityRemark;

import java.util.List;

/**
 * @author HYP
 * @create 2020-11-16 20:09
 */
public interface ActivityRemarkDao {
    int getCountByAids(String[] ids);

    int deleteByAids(String[] ids);

    List<ActivityRemark> getRemarkListByAid(String activityId);

    int deleteRemark(String id);

    int saveRemark(ActivityRemark ar);

    int updateRemark(ActivityRemark ar);
}
