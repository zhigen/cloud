package com.zglu.service;

import com.zglu.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sys")
public interface SysApi {

    @GetMapping(value = "/role-permission?url={url}&method={method}&token={token}")
    Result get(@PathVariable("url") String url, @PathVariable("method") String method, @PathVariable("token") String token);

}