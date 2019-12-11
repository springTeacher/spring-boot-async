package com.xiaoniu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author lhj
 * @date 2019/12/11 18:05
 */
@Aspect
@Component
public class LogAspect {




    @Pointcut("execution(* com.xiaoniu.controller.*.*(..))")
    public void pointCut(){

    }




    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class returnType = signature.getReturnType();
        System.out.println(returnType);
        System.out.println(signature.getMethod().getName());
    }



}
