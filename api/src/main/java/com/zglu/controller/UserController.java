package com.zglu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @ResponseBody
    @GetMapping(value = "/test")
    String get(){
        return "zglu";
    }
}
