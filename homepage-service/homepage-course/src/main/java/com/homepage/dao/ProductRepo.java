package com.homepage.dao;

import com.homepage.entity.HomepageCourse;
import com.homepage.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
    //public Product findById(Long id);

}
