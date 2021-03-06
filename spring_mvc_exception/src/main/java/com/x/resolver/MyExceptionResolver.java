package com.x.resolver;

import com.x.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gavin
 */
public class MyExceptionResolver implements HandlerExceptionResolver {

    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e: 异常对象
     * @return 跳转到错误视图信息
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();

        if (e instanceof MyException) {
            modelAndView.addObject("info", "自定义异常");
        } else if (e instanceof ClassCastException) {
            modelAndView.addObject("info", "类型转换异常");
        }

        modelAndView.setViewName("error");

        return modelAndView;
    }
}
