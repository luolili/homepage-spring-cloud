package com.homepage.datalog;

import com.homepage.entity.Action;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActionRepo extends MongoRepository<Action, String> {
}
