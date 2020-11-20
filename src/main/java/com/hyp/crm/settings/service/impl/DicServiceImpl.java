package com.hyp.crm.settings.service.impl;

import com.hyp.crm.settings.dao.DicTypeDao;
import com.hyp.crm.settings.dao.DicValueDao;
import com.hyp.crm.settings.service.DicService;
import com.hyp.crm.utils.SqlSessionUtil;

/**
 * @author HYP
 * @create 2020-11-20 20:40
 */
public class DicServiceImpl implements DicService {
    private DicTypeDao dicTypeDao = SqlSessionUtil.getSqlSession().getMapper(DicTypeDao.class);
    private DicValueDao dicValueDao = SqlSessionUtil.getSqlSession().getMapper(DicValueDao.class);
}
