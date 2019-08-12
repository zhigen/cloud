package com.zglu.service;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Amap", url = "https://restapi.amap.com")
public interface AmapApi {

    String key = "faf57b382ed93b42768a641349debc9f";

    @GetMapping("/v3/geocode/geo?address={address}&output=JSON&key=" + key)
    String geo(@Param("address") String address);

}