package com.zglu.controller;

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
        return role.getId()+"";
    }
}
