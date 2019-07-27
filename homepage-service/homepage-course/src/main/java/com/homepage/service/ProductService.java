package com.homepage.service;

import com.homepage.entity.Product;
import com.homepage.security.AdminOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private AuthService authService;//要加@Component

    @AdminOnly
    public void insert(Product product) {
        //传统方法有侵入性
        //authService.checkAccess();
        System.out.println("insert p");
    }

    @AdminOnly
    public void delete(Long id) {
        System.out.println("delete p");
    }


}
