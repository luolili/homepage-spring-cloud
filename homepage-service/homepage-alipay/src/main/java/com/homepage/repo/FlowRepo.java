package com.homepage.repo;

import com.homepage.entity.Flow;
import com.homepage.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowRepo extends JpaRepository<Flow, String> {
}
