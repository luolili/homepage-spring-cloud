package com.homepage.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecAspect {


    //public表示方法的修饰符， 第一个* 表示返回值，
    @Pointcut("execution(public * com.homepage.service.*Service.*(..))")
    public void test() {

    }

    @Before("test()")
    public void doBefore() {
        System.out.println("arg ");
    }
}
