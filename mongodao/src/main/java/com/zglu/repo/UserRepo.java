package com.zglu.repo;

import com.zglu.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepo extends ReactiveMongoRepository<User,String> {
    @Tailable
    Flux<User> findBy();
}