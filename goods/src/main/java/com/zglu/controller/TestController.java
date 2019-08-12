package com.zglu.controller;

import com.zglu.service.AmapApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private AmapApi amapApi;

    @GetMapping("/map")
    public String map(){
        return amapApi.geo("南宁饭店");
    }
}