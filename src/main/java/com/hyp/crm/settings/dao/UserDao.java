package com.hyp.crm.settings.dao;

import com.hyp.crm.settings.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author HYP
 * @create 2020-11-15 19:16
 */
public interface UserDao {
    User login(Map<String,String> map);
    List<User> getUserList();

}
