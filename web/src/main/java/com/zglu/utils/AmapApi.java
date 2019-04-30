package com.zglu.utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Amap", url = "https://restapi.amap.com")
public interface AmapApi {

    String key = "faf57b382ed93b42768a641349debc9f";

    @GetMapping(value = "/v3/geocode/geo?address={address}&output=JSON&key="+key)
    String geo(@PathVariable("address") String address);

}