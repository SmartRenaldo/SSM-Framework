package com.x.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Gavin
 */
@Component("myAspect")
@Aspect //标注当前MyAspect是一个切面类
public class MyAspect {

    //配置前置通知
    //@Before("execution(* com.x.anno.*.*(..))")
    public void before() {
        System.out.println("前置增强..........");
    }

    public void afterReturning() {
        System.out.println("后置增强..........");
    }

    // ProceedingJoinPoint: 正在执行的连接点，切点
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强..........");
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强..........");

        return proceed;
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("异常抛出增强..........");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("最终增强..........");
    }

    @Pointcut("execution(* com.x.anno.*.*(..))")
    public void pointcut() {}
}
