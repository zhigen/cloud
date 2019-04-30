package com.zglu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class Test {

    @Autowired
    private TestHandle testHandle;

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return route(GET("/test/{id}/{id2}"), req -> testHandle.test(req))
                .andRoute(POST("/test/test/{id}"), req -> testHandle.test2(req))
                .andRoute(GET("/times"), testHandle::times)
                .andRoute(POST("/user/{name}"), req -> testHandle.save(req));
    }
}