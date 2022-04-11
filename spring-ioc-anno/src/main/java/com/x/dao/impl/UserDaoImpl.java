package com.x.dao.impl;

import com.x.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author Gavin
 */
// <bean id="userDao" class="com.x.dao.impl.UserDaoImpl"/>
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Value("阿三")
    private String name;
    @Value("${driver}")
    private String driver;

    @Override
    public void save() {
        System.out.println(name);
        System.out.println(driver);
        System.out.println("save running...");
    }
}
