package com.zglu.controller;

import com.zglu.service.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserApi userApi;

    @ResponseBody
    @GetMapping(value = "/test")
    public String router(){
        return userApi.test();
    }
}