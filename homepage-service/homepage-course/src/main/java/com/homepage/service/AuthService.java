package com.homepage.service;

import com.homepage.security.CurrentUserHolder;
import org.springframework.stereotype.Component;

/**
 * 只有管理员才可以添加，删除商品
 */
@Component
public class AuthService {

    public void checkAccess() {
        String user = CurrentUserHolder.getUser();
        if (!"admin".equals(user)) {
            throw new RuntimeException();
        }


    }

}
