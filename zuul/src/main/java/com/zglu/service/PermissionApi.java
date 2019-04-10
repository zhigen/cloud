package com.zglu.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sys")
public interface PermissionApi {

    @GetMapping(value = "/check/{id}")
    Boolean get(@PathVariable("id") int id);

}
