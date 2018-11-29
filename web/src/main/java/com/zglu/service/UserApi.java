package com.zglu.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("eureka-provider")
public interface UserApi {

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    String test();

}
