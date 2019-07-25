package com.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.homepage.CourseInfo;
import com.homepage.CourseInfosRequest;
import com.homepage.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class HomepageCourseController {

    @Autowired
    private ICourseService courseService;

    /**
     * http://localhost:9000/hp/homepage-course/get/course?id=1
     *
     * @param id id
     * @return CourseInfo
     */
    @GetMapping("/get/course")
    public CourseInfo getCourseInfo(Long id) {
        log.info("course id:{}", id);
        return courseService.getCourseInfo(id);
    }

    @PostMapping("/get/courses")
    public List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request) {
        log.info("course ids:{}", JSON.toJSONString(request));
        return courseService.getCourseInfos(request);
    }

}
