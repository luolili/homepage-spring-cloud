package com.homepage.service;

import com.alibaba.fastjson.JSON;
import com.homepage.App;
import com.homepage.CourseInfosRequest;
import com.homepage.dao.HomepageCourseRepo;
import com.homepage.entity.HomepageCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * 服务的test case
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {App.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HomepageCourseServiceTest {


    @Autowired
    private HomepageCourseRepo homepageCourseRepo;
    @Autowired
    private ICourseService courseService;

    // @Test
    public void stAdd() {
        HomepageCourse course01 =
                new HomepageCourse("JDK新", "learn", "http", 0);

        HomepageCourse course02 =
                new HomepageCourse("spring", "sc", "httpsd", 1);
        System.out.println(homepageCourseRepo.saveAll(Arrays.asList(course01, course02)).size());


    }

    @Test
    public void testGet() {
        System.out.println(JSON.toJSONString(courseService.getCourseInfo(1L)));
        System.out.println(JSON.toJSONString(courseService.getCourseInfo(3L)));
    }

    @Test
    public void testGetList() {
        System.out.println(JSON.toJSONString(courseService.getCourseInfos(
                new CourseInfosRequest(Arrays.asList(1L, 2L)))));
    }
}
