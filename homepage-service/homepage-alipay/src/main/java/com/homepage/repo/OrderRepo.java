package com.homepage.repo;

import com.homepage.entity.Order;
import com.homepage.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, String> {
}
