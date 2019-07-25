package com.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.homepage.UserInfo;
import com.homepage.service.IUserService;
import com.homepage.vo.CreateUserRequest;
import com.homepage.vo.UserCourseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/user/create")
    public UserInfo add(@RequestBody CreateUserRequest request) {
        log.info("user: {}", JSON.toJSONString(request));
        return userService.add(request);
    }

    /**
     * http://localhost:9000/hp/homepage-user/user/get?id=3
     *
     * @param id id
     * @return UserInfo
     */
    @GetMapping("/user/get")
    public UserInfo getUserInfo(Long id) {
        log.info("user id: {}", JSON.toJSONString(id));
        return userService.getUserInfo(id);
    }

    @GetMapping("/user/course/get")
    public UserCourseInfo getUserCourseInfo(Long userId) {
        log.info("user id: {}", JSON.toJSONString(userId));
        return userService.getUserCourseInfo(userId);
    }
}
