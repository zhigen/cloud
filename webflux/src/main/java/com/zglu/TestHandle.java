package com.zglu;

import com.zglu.dao.entity.User;
import com.zglu.dao.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class TestHandle {

    @Autowired
    private UserRepo userRepo;

    public Mono<ServerResponse> test(ServerRequest serverRequest) {
        System.out.println(serverRequest.pathVariables());
        String id = serverRequest.pathVariable("id");
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just(id), String.class);
    }

    public Mono<ServerResponse> test2(ServerRequest serverRequest) {
        System.out.println(serverRequest.pathVariables());
        String id = serverRequest.pathVariable("id");
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just(id), String.class);
    }

    public Mono<ServerResponse> times(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_EVENT_STREAM).body(
                Flux.interval(Duration.ofSeconds(1)).map(l -> new SimpleDateFormat("HH:mm:ss").format(new Date())),
                String.class);
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        String name = serverRequest.pathVariable("name");
        User user = new User();
        user.setName(name);
        userRepo.save(user);
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just(user), User.class);
    }
}