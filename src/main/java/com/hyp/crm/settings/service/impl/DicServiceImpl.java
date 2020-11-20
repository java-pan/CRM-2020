package com.hyp.crm.settings.service.impl;

import com.hyp.crm.settings.dao.DicTypeDao;
import com.hyp.crm.settings.dao.DicValueDao;
import com.hyp.crm.settings.domain.DicType;
import com.hyp.crm.settings.domain.DicValue;
import com.hyp.crm.settings.service.DicService;
import com.hyp.crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HYP
 * @create 2020-11-20 20:40
 */
public class DicServiceImpl implements DicService {
    private DicTypeDao dicTypeDao = SqlSessionUtil.getSqlSession().getMapper(DicTypeDao.class);
    private DicValueDao dicValueDao = SqlSessionUtil.getSqlSession().getMapper(DicValueDao.class);

    public Map<String, List<DicValue>> getAll() {
        Map<String, List<DicValue>> map = new HashMap<String, List<DicValue>>();

        //将字典类型列表取出
        List<DicType> dtList =  dicTypeDao.getTypeList();
        //将字典类型列表遍历，根据7种类型来取值的列表
        for (DicType dt:dtList){
            //取得每一种类型的字典类型编码
            String code = dt.getCode();
            //根据每一个字典类型来取得字典值列表
             List<DicValue> dvList= dicValueDao.getListByCode(code);
             map.put(code+"List",dvList);

        }


        return map;
    }
}
