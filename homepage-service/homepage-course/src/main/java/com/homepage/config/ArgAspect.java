package com.homepage.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ArgAspect {


    @Pointcut("args(Long) && within(com.homepage.service.*)")
    public void test() {

    }

    @Before("test()")
    public void doBefore() {
        System.out.println("arg ");
    }
}
