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

    //拦截有AdminOnly 注解的方法
    @Pointcut("@annotation(AdminOnly)")
    public void adminOnly() {

    }

    @Before("adminOnly()")
    public void check() {
        authService.checkAccess();
    }
}
