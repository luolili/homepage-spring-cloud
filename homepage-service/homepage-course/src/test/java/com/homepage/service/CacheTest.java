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

    @Test
    public void testMenuCache() {
        System.out.println("call: " + cacheMenuService.getMenuList());
        System.out.println("call: " + cacheMenuService.getMenuList());

    }
}
