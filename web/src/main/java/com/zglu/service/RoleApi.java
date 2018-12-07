package com.zglu.service;

import com.zglu.vo.RoleVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sys")
public interface RoleApi {

    @GetMapping(value = "/role/{id}")
    RoleVo get(@PathVariable("id") int id);

}
