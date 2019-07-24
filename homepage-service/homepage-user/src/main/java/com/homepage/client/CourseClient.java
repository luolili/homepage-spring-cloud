package com.homepage.client;

import com.homepage.CourseInfo;
import com.homepage.CourseInfosRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 通过feign 访问接口
 */
@FeignClient(value = "eureka-client-homepage-course",
        fallback = CourseClientHystrix.class)
public interface CourseClient {

    @GetMapping("/homepage-course/get/course")
    CourseInfo getCourseInfo(Long id);

    @PostMapping("/homepage-course/get/courses")
    List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request);


}
