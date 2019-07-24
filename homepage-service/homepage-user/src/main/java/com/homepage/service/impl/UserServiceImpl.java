package com.homepage.service.impl;

import com.homepage.CourseInfo;
import com.homepage.CourseInfosRequest;
import com.homepage.UserInfo;
import com.homepage.client.CourseClient;
import com.homepage.dao.UserCourseRepo;
import com.homepage.dao.UserRepo;
import com.homepage.entity.HomepageUser;
import com.homepage.entity.HomepageUserCourse;
import com.homepage.service.IUserService;
import com.homepage.vo.CreateUserRequest;
import com.homepage.vo.UserCourseInfo;
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
public class UserServiceImpl implements IUserService {

    private UserRepo userRepo;

    private UserCourseRepo userCourseRepo;
    private CourseClient courseClient;

    @Autowired
    private UserServiceImpl(UserRepo userRepo, UserCourseRepo userCourseRepo, CourseClient courseClient) {
        this.userRepo = userRepo;
        this.userCourseRepo = userCourseRepo;
        this.courseClient = courseClient;
    }

    @Override
    public UserInfo add(CreateUserRequest request) {
        if (!request.vaidate()) {
            return UserInfo.invalid();
        }
        HomepageUser oldUser = userRepo.findByUsername(request.getUsername());

        if (null != oldUser) {
            return UserInfo.invalid();
        }

        HomepageUser user = userRepo.save(new HomepageUser(request.getUsername(), request.getEmail()));


        return new UserInfo(user.getId(), user.getUsername(), user.getEmail());
    }

    @Override
    public UserInfo getUserInfo(Long id) {
        Optional<HomepageUser> userOptional = userRepo.findById(id);

        if (!userOptional.isPresent()) {
            return UserInfo.invalid();
        }
        HomepageUser user = userOptional.get();
        return new UserInfo(user.getId(), user.getUsername(), user.getEmail());
    }

    @Override
    public UserCourseInfo getUserCourseInfo(Long userId) {
        Optional<HomepageUser> userOptional = userRepo.findById(userId);

        if (!userOptional.isPresent()) {
            return UserCourseInfo.invalid();
        }
        HomepageUser user = userOptional.get();
        UserInfo userInfo = new UserInfo(user.getId(), user.getUsername(), user.getEmail());

        List<HomepageUserCourse> userCourses =
                userCourseRepo.findAllByUserId(userId);
        if (CollectionUtils.isEmpty(userCourses)) {
            return new UserCourseInfo(userInfo, Collections.emptyList());
        }

        List<CourseInfo> courseInfos = courseClient.getCourseInfos(
                new CourseInfosRequest(userCourses.stream().map(HomepageUserCourse::getCourseId)
                        .collect(Collectors.toList()))
        );

        return new UserCourseInfo(userInfo, courseInfos);
        ;
    }
}
