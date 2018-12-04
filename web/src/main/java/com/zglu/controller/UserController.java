package com.zglu.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.zglu.service.UserApi;
import com.zglu.utils.AmapApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserApi userApi;
    @Autowired
    private AmapApi amapApi;

    @ResponseBody
    @GetMapping(value = "/test")
    public String router(){
        return userApi.test();
    }

    @ResponseBody
    @GetMapping(value = "/test1")
    public JsonNode test1(){
        return amapApi.geo("南宁饭店");
    }

}