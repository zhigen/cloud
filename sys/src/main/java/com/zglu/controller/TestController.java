package com.zglu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/test/{id}")
    public String test(@PathVariable String id) {
        return "/test/{id}";
    }

    @GetMapping(value = "/test/test")
    public String test1() {
        return "/test/test";
    }
}