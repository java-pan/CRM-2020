package com.hyp.crm.workbench.dao;

import com.hyp.crm.workbench.domain.Activity;
import com.hyp.crm.workbench.domain.Clue;

public interface ClueDao {


    int save(Clue c);

    Clue detail(String id);

    int deleteActivityById(String id);
}
