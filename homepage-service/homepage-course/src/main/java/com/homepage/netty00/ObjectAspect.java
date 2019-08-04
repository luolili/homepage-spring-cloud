package com.homepage.netty00;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ObjectAspect {


    @Pointcut("this(com.homepage.log.Logger)")
    public void test() {

    }

    @Before("test()")
    public void doBefore() {
        System.out.println("logger ");
    }
}
