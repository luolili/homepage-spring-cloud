package com.homepage.service;

import com.alibaba.fastjson.JSON;
import com.homepage.dao.UserCourseRepo;
import com.homepage.entity.HomepageUserCourse;
import com.homepage.vo.CreateUserRequest;
import com.netflix.discovery.converters.Auto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserCourseRepo userCourseRepo;

    @Test
    // @Transactional//这里要回滚，也就是不会插入这条数据
    public void testAdd() {
        System.out.println(JSON.toJSONString(
                userService.add(new CreateUserRequest("qinyi", "qiyu"))));

    }

    @Test
    public void testGetUserInfo() {
        System.out.println(JSON.toJSONString(userService.getUserInfo(2L)));
    }

    @Test
    public void testAddUserCourse() {
        HomepageUserCourse userCourse01 = new HomepageUserCourse();
        userCourse01.setUserId(2L);
        userCourse01.setCourseId(1L);
        HomepageUserCourse userCourse02 = new HomepageUserCourse();
        userCourse02.setUserId(2L);
        userCourse02.setCourseId(2L);
        List<HomepageUserCourse> lisy = userCourseRepo.saveAll(Arrays.asList(userCourse01, userCourse02));

        System.out.println(lisy.size());


    }
}
