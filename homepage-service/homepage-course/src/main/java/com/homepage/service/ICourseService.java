package com.homepage.service;

import com.homepage.CourseInfo;
import com.homepage.CourseInfosRequest;

import java.util.List;


public interface ICourseService {

    CourseInfo getCourseInfo(Long id);

    List<CourseInfo> getCourseInfos(CourseInfosRequest request);
}
