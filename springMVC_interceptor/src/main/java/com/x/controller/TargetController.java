package com.x.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Gavin
 */
@Controller
public class TargetController {

    @RequestMapping("/target")
    public ModelAndView show() {
        System.out.println("目标资源执行...");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "Yiqi");
        modelAndView.setViewName("index");

        return  modelAndView;
    }

}
