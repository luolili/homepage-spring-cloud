package com.homepage.security;

import com.homepage.service.AuthService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthAspect {

    @Autowired
    private AuthService authService;

    /**
     *within()括号里面是类的全路径名
     */
    //拦截有AdminOnly 注解的方法
    @Pointcut("@annotation(AdminOnly)")
    //匹配制定的类里面的所有的方法
    //@Pointcut("within(com.homepage.service.ProductService)")

    //匹配com.homepage包以及其子包下面的所有类的方法
    //@Pointcut("within(com.homepage.*)")
    public void adminOnly() {

    }

    @Before("adminOnly()")//在adminOnly方法执行之前check
    public void check() {
        authService.checkAccess();
    }
}
