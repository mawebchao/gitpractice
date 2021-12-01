package com.project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class TestAop {
    @Pointcut("execution(* com.project.pojo.*.*(..))")
    public void pointcut() {
    }

    @Pointcut("execution(* com.project.pojo.*.*(..))")
    public void pointcuthhh() {
    }

    @Before("pointcut()")
    public void recordBefore() {
        System.out.println("前置方法执行了");
    }

    @After("pointcut()")
    public void recordAfter() {
        System.out.println("后置方法执行了");
    }

    @Around("pointcut()")
    public Object around1(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-----------around方法的前置方法执行了------------");
        Object result = joinPoint.proceed();
        System.out.println("-----------around方法的后置方法执行了------------");
        return result;
    }

    @Around("pointcuthhh()")
    public Object around2(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-----------around方法的前置方法执行了------------");
        Object result = joinPoint.proceed();
        System.out.println("-----------around方法的后置方法执行了------------");
        return result;
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("--------正常返回的切面方法执行了----------");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("--------异常抛出的切面方法执行了----------");
    }
}
