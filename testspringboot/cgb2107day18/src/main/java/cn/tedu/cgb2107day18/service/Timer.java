package cn.tedu.cgb2107day18.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Timer {
    //切点表达式： *表示1个 ..表示多个 *依次代表方法返回值，类名，方法名，(..)是参数列表
    @Pointcut("execution(* cn.tedu.cgb2107day18.controller.TestController.*(..))")
    public void pointcut1(){}
    @Before("pointcut1()")
    public void beforeMethod(){
        System.out.println("我是前置通知");
    }
    @After("pointcut1()")
    public void afterMethod(){
        System.out.println("我是后置通知");
    }
    @Around("pointcut1()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long time=System.currentTimeMillis();
        Object o=joinPoint.proceed();
        time=System.currentTimeMillis()-time;
        System.out.println(joinPoint.getSignature().getDeclaringTypeName()+"中的"+joinPoint.getSignature().getName()+"方法耗时"+time+"毫秒");
        return o;
    }
}
