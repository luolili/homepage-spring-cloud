package com.homepage.client;

import com.homepage.CourseInfo;
import com.homepage.CourseInfosRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 熔断降级
 */
@Component
public class CourseClientHystrix implements CourseClient {
    @Override
    public CourseInfo getCourseInfo(Long id) {
        return CourseInfo.invalid();
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        return Collections.emptyList();
    }
}
