package com.homepage.vo;

import com.homepage.CourseInfo;
import com.homepage.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseInfo {

    UserInfo userInfo;
    List<CourseInfo> courseInfoList;

    public static UserCourseInfo invalid() {
        return new UserCourseInfo(UserInfo.invalid(), Collections.emptyList());
    }
}
