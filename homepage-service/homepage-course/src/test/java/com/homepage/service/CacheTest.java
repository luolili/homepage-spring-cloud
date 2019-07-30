package com.homepage.service;

import com.netflix.discovery.converters.Auto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {

    @Autowired
    private CacheMenuService cacheMenuService;

    /**
     * result:
     * mock: get from db
     * call: [xc, rf, tg]
     * 第二次调用
     * call: [xc, rf, tg]
     */
    @Test
    public void testMenuCache() {
        System.out.println("call: " + cacheMenuService.getMenuList());
        System.out.println("call: " + cacheMenuService.getMenuList());

    }
}
