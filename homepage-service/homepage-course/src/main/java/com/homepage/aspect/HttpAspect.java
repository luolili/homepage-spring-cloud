package com.homepage.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {

    /**
     * 先写好方法，   在写@Before的时候才有提示
     * ..表示可以匹配所有的参数
     */
    @Before("execution(public * com.homepage.controller.HomepageCourseController.getCourseInfos(..))")
    //拦截所有的方法
    //@Before("execution(public * com.homepage.controller.HomepageCourseController.*(..))")
    public void log() {

        System.out.println("--");

    }
}
