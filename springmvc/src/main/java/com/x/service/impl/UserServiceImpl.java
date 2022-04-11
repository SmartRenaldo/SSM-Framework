package com.x.service.impl;

import com.x.dao.UserDao;
import com.x.service.UserService;

/**
 * @author Gavin
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.save();
    }
}
