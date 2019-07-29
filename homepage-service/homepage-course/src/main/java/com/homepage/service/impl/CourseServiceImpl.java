package com.homepage.service.impl;

import com.homepage.CourseInfo;
import com.homepage.CourseInfosRequest;
import com.homepage.dao.HomepageCourseRepo;
import com.homepage.entity.HomepageCourse;
import com.homepage.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CourseServiceImpl implements ICourseService {

    //@Autowired
    private HomepageCourseRepo homepageCourseRepo;

    @Autowired
    public CourseServiceImpl(HomepageCourseRepo homepageCourseRepo) {
        this.homepageCourseRepo = homepageCourseRepo;
    }

    @Override
    public CourseInfo add(CourseInfo courseInfo) {
        return homepageCourseRepo.save(courseInfo);
    }

    @Override
    public CourseInfo getCourseInfo(Long id) {
        Optional<HomepageCourse> course = homepageCourseRepo.findById(id);

        return buildCourseInfo(course.orElse(HomepageCourse.invalid()));
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        if (CollectionUtils.isEmpty(request.getIds())) {
            return Collections.emptyList();
        }
        List<HomepageCourse> courses = homepageCourseRepo.findAllById(request.getIds());
        return courses.stream()
                .map(this::buildCourseInfo)
                .collect(Collectors.toList());

    }

    private CourseInfo buildCourseInfo(HomepageCourse homepageCourse) {
        return CourseInfo.builder()
                .id(homepageCourse.getId())
                .courseName(homepageCourse.getCourseName())
                .courseType(homepageCourse.getCourseType() == 0 ? "免费" : "实战")
                .courseIcon(homepageCourse.getCourseIcon())
                .courseIntro(homepageCourse.getCourseIntro())
                .build();
    }

    
}
