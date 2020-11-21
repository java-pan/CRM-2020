package com.hyp.crm.workbench.service;

import com.hyp.crm.workbench.domain.Activity;
import com.hyp.crm.workbench.domain.Clue;

/**
 * @author HYP
 * @create 2020-11-20 19:43
 */
public interface ClueService {
    boolean save(Clue c);

    Clue detail(String id);


}
