package com.zglu.controller;

import com.zglu.entity.Role;
import com.zglu.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;

    @ResponseBody
    @GetMapping(value = "/role/{id}")
    Role get(@PathVariable int id){
        Role role = roleRepo.findById(id).get();
        return role;
    }
}
