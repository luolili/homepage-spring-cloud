package com.homepage.dao;

import com.homepage.entity.HomepageUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<HomepageUser, Long> {
    HomepageUser findByUsername(String username);


}
