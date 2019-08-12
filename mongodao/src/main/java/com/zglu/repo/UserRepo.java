package com.zglu.repo;

import com.zglu.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends ReactiveMongoRepository<User, String> {

}