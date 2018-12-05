package com.zglu.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "api")
public interface UserApi {

    @GetMapping(value = "/test")
    String test();

}
