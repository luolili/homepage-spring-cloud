package com.homepage.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 先写好方法，   在写@Before的时候才有提示
     * ..表示可以匹配所有的参数
     */
   /* @Before("execution(public * com.homepage.controller.HomepageCourseController.getCourseInfo(..))")
    //拦截所有的方法
    //@Before("execution(public * com.homepage.controller.HomepageCourseController.*(..))")
    public void log() {

        System.out.println("-before-");

    }*/

    //另外一种写法
    @Pointcut("execution(public * com.homepage.controller.HomepageCourseController.getCourseInfo(..))")
    //拦截所有的方法
    //@Before("execution(public * com.homepage.controller.HomepageCourseController.*(..))")
    public void log01() {
        //System.out.println("-before-");
    }

    //2019-07-27 13:26:36.409  INFO 8576 --- [nio-7001-exec-1] com.homepage.aspect.HttpAspect   : beifre
    @Before("log01()")
    public void doBefore() {
        //System.out.println("ii");
        logger.info("beifre");
    }

    @After("execution(public * com.homepage.controller.HomepageCourseController.getCourseInfo(..))")
    //拦截所有的方法
    //@Before("execution(public * com.homepage.controller.HomepageCourseController.*(..))")
    public void after() {

        System.out.println("-after-");

    }
}
