package com.x.web;

import com.x.config.SpringConfiguration;
import com.x.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Gavin
 */
public class UserController {
    public static void main(String[] args) {
        // ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();

        UserService userService1 = app.getBean(UserService.class);
        System.out.println("userService == userService1: " + (userService == userService1));
        app.close();
    }
}
