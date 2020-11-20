package com.hyp.crm.settings.service;

import com.hyp.crm.settings.domain.DicValue;

import java.util.List;
import java.util.Map;

/**
 * @author HYP
 * @create 2020-11-20 20:40
 */
public interface DicService {
    Map<String, List<DicValue>> getAll();
}
