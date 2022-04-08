package com.x.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gavin
 */
public class MyInterceptor1 implements HandlerInterceptor {

    // 在目标方法执行之前执行
    // 返回值为false的话，后面内容将全部无法执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");

        String param = request.getParameter("param");
        if ("yes".equals(param)) {
            return true;
        }

        request.getRequestDispatcher("/error.jsp").forward(request, response);
        return false;
    }

    // 在目标方法执行之后 视图返回之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");

        modelAndView.addObject("name", "Niubi");
    }

    // 在全部流程执行完毕后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
