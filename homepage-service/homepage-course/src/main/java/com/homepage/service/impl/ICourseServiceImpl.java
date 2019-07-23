package com.homepage.service.impl;

import com.homepage.CourseInfo;
import com.homepage.CourseInfosRequest;
import com.homepage.dao.HomepageCourseRepo;
import com.homepage.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ICourseServiceImpl implements ICourseService {

    //@Autowired
    private HomepageCourseRepo homepageCourseRepo;

    @Autowired
    public ICourseServiceImpl(HomepageCourseRepo homepageCourseRepo) {
        this.homepageCourseRepo = homepageCourseRepo;

    }

    @Override
    public CourseInfo getCourseInfo(Long id) {
        return null;
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        return null;
    }
}
