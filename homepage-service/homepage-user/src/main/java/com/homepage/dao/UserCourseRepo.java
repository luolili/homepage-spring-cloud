package com.homepage.dao;

import com.homepage.entity.HomepageUser;
import com.homepage.entity.HomepageUserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCourseRepo extends JpaRepository<HomepageUserCourse, Long> {
    List<HomepageUserCourse> findAllByUserId(Long userId);


}
