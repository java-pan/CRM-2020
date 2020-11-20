package com.hyp.crm.settings.dao;

import com.hyp.crm.settings.domain.DicValue;

import java.util.List;

/**
 * @author HYP
 * @create 2020-11-20 20:16
 */
public interface DicValueDao {
    List<DicValue> getListByCode(String code);
}
