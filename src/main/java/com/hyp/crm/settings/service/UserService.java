package com.hyp.crm.settings.service;

import com.hyp.crm.exception.LoginException;
import com.hyp.crm.settings.domain.User;

import java.util.List;

/**
 * @author HYP
 * @create 2020-11-15 19:19
 */
        public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
