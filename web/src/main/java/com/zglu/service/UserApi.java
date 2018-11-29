package com.zglu.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("api")
public interface UserApi {

    @GetMapping(value = "/test")
    String test();

}
