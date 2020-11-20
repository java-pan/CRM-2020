package com.hyp.crm.workbench.service.impl;

import com.hyp.crm.utils.SqlSessionUtil;
import com.hyp.crm.workbench.dao.ClueDao;
import com.hyp.crm.workbench.service.ClueService;

/**
 * @author HYP
 * @create 2020-11-20 19:44
 */
public class ClueServiceImpl extends ClueService {
    private ClueDao clueDao = SqlSessionUtil.getSqlSession().getMapper(ClueDao.class);



}
