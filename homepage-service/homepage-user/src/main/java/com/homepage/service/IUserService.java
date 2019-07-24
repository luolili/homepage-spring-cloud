package com.homepage.service;

import com.homepage.UserInfo;
import com.homepage.vo.CreateUserRequest;
import com.homepage.vo.UserCourseInfo;

public interface IUserService {

    UserInfo add(CreateUserRequest request);

    UserInfo getUserInfo(Long id);

    UserCourseInfo getUserCourseInfo(Long userId);
}
