package com.x.service.impl;

import com.x.dao.UserDao;
import com.x.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author Gavin
 */
// <bean id="userService" class="com.x.service.impl.UserServiceImpl">
//@Component("userService")
@Service("userService")
@Scope("singleton")
//@Scope("prototype")
public class UserServiceImpl implements UserService {
    //<property name="userDao" ref="userDao"/>
    //@Autowired //按照数据类型从Spring容器中进行匹配的
    //@Qualifier("userDao") //是按照id值从容器中进行匹配的 但主要此处@Qualifier和@Autowired一起使用
    @Resource(name="userDao") // 相当于@Qualifier和@Autowired一起使用
    private UserDao userDao;

    // 有Autowired可以省略set方法
    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    @PostConstruct
    public void init() {
        System.out.println("Service对象的初始化方法");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Service对象销毁方法");
    }

    @Override
    public void save() {
        userDao.save();
    }
}
