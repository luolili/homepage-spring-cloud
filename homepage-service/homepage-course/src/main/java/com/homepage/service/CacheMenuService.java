package com.homepage.service;

import com.homepage.util.ApplicationContextHolder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CacheMenuService {

    @Cacheable(cacheNames = {"menu"})

    public List<String> getMenuList() {
        System.out.println(" ");
        System.out.println("mock: get from db");
        return Arrays.asList("xc", "rf", "tg");
    }

    //没有代理CacheMenuService
    public List<String> getComments() {
        //内部调用
        //解决方法
        CacheMenuService proxy = ApplicationContextHolder.getCtx().getBean(CacheMenuService.class);

        return proxy.getMenuList();
        //return this.getMenuList();
    }

}
