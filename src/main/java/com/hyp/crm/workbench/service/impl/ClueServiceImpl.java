package com.hyp.crm.workbench.service.impl;

import com.hyp.crm.utils.SqlSessionUtil;
import com.hyp.crm.utils.UUIDUtil;
import com.hyp.crm.workbench.dao.ActivityDao;
import com.hyp.crm.workbench.dao.ClueActivityRelationDao;
import com.hyp.crm.workbench.dao.ClueDao;
import com.hyp.crm.workbench.domain.Activity;
import com.hyp.crm.workbench.domain.Clue;
import com.hyp.crm.workbench.domain.ClueActivityRelation;
import com.hyp.crm.workbench.service.ClueService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HYP
 * @create 2020-11-20 19:44
 */
public class ClueServiceImpl implements ClueService {
    private ClueDao clueDao = SqlSessionUtil.getSqlSession().getMapper(ClueDao.class);
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
    private ClueActivityRelationDao clueActivityRelationDao = SqlSessionUtil.getSqlSession().getMapper(ClueActivityRelationDao.class);

    public boolean bund(String cid, String[] aids) {
        boolean flag = true;
        for (String aid:aids){
            //取得，每一个aid和cid做关联
            ClueActivityRelation car = new ClueActivityRelation();
            car.setId(UUIDUtil.getUUID());
            car.setActivityId(aid);
            car.setClueId(cid);
            //添加关联关系表中的记录
            int count = clueActivityRelationDao.bund(car);
            if (count!=1){
                flag = false;
            }

        }
        return flag;
    }

    public boolean deleteActivityById(String id) {
        boolean flag = true;
        int count = clueDao.deleteActivityById(id);
        if (count!=1){
            flag = false;
        }
        return flag;
    }

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
