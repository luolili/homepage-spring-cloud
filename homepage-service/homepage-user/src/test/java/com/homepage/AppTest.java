package com.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.homepage"})
@SpringBootApplication//注意这里：项目里面不能有多个类上都有这个注解
public class AppTest {

    public static void main(String[] args) {
        SpringApplication.run(AppTest.class, args);
    }
}
