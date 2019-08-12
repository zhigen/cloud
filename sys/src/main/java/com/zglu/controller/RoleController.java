package com.zglu.controller;

import com.zglu.dao.entity.Role;
import com.zglu.dao.repo.RoleRepo;
import com.zglu.result.Result;
import com.zglu.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/role/{id}")
    public Result<Role> get(@PathVariable int id) {
        Role role = roleRepo.findById(id).orElse(null);
        if (role == null) {
            return Result.error(ResultCode.DATA_NOT_EXIST);
        }
        return Result.success(role);
    }
}