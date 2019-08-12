package com.zglu.controller;

import com.zglu.entity.User;
import com.zglu.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public Mono<User> save(@RequestBody User user) {
        return userRepo.save(user);
    }

    @GetMapping("/{id}")
    public Mono<User> save(@PathVariable String id) {
        return userRepo.findById(id);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> save() {
        return userRepo.findAll();
    }

    @Bean
    public CommandLineRunner initData(MongoOperations mongo) {
        return (String... args) -> {
            mongo.dropCollection(User.class);
            mongo.createCollection(User.class, CollectionOptions.empty().maxDocuments(10).size(20000).capped());
        };
    }
}