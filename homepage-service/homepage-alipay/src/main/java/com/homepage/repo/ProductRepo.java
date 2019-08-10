package com.homepage.repo;

import com.homepage.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {
}
