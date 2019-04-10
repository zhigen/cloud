package com.zglu.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sys")
public interface RoleApi {

    @GetMapping(value = "/role/{id}")
    String get(@PathVariable("id") int id);

}
