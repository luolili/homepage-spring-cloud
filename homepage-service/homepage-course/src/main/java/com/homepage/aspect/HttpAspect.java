package com.homepage.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpServletRequest;

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
    public void doBefore(JoinPoint joinPoint) {
        //System.out.println("ii");
        logger.info("beifre");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        StringBuffer requestURL = request.getRequestURL();
        logger.info("url: {}", requestURL);
        //method
        logger.info("method: {}", request.getMethod());
        //ip
        logger.info("remote ip: {}", request.getRemoteAddr());
        //
        logger.info("class method: {}", joinPoint.getSignature().getDeclaringTypeName());
        //参数
        logger.info("  method args: {}", joinPoint.getArgs());



    }

    @After("execution(public * com.homepage.controller.HomepageCourseController.getCourseInfo(..))")
    //拦截所有的方法
    //@Before("execution(public * com.homepage.controller.HomepageCourseController.*(..))")
    public void after() {

        System.out.println("-after-");

    }

    //获取方法的返回值
    @AfterReturning(pointcut = "log01()", returning = "obj")
    public void doAfterReturning(Object obj) {
        logger.info("returned value: {}", obj);
    }
}
