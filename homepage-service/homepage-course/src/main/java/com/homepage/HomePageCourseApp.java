package com.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableEurekaClient
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)//强制使用cglib
@EnableCaching//开启aop的缓存，否则他不会有缓存的功能
public class HomePageCourseApp {
    public static void main(String[] args) {
        SpringApplication.run(HomePageCourseApp.class, args);
    }
}
