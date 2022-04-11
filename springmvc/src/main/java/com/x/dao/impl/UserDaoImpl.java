package com.x.dao.impl;

import com.x.dao.UserDao;

/**
 * @author Gavin
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save running...");
    }
}
