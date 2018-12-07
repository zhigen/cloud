package com.zglu.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zglu.entity.Role;
import com.zglu.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private RoleRepo roleRepo;

    @ResponseBody
    @GetMapping(value = "/test")
    String get(){
        Role role = roleRepo.save(new Role());
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        return gson.toJson(role);
    }
}
