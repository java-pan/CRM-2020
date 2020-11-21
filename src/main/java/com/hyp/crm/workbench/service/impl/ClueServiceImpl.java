package com.hyp.crm.workbench.service.impl;

import com.hyp.crm.utils.SqlSessionUtil;
import com.hyp.crm.workbench.dao.ActivityDao;
import com.hyp.crm.workbench.dao.ClueDao;
import com.hyp.crm.workbench.domain.Activity;
import com.hyp.crm.workbench.domain.Clue;
import com.hyp.crm.workbench.service.ClueService;

/**
 * @author HYP
 * @create 2020-11-20 19:44
 */
public class ClueServiceImpl implements ClueService {
    private ClueDao clueDao = SqlSessionUtil.getSqlSession().getMapper(ClueDao.class);
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);




    public Clue detail(String id) {
        Clue clue = clueDao.detail(id);
        return clue;
    }

    public boolean save(Clue c) {
        boolean flag = true;
        int count = clueDao.save(c);
        if (count!=1){
            flag = false;
        }
        return flag;
    }
}
