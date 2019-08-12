package com.zglu.controller;

import com.zglu.dao.entity.Permission;
import com.zglu.dao.repo.PermissionRepo;
import com.zglu.result.Result;
import com.zglu.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PermissionController {

    @Autowired
    private PermissionRepo permissionRepo;

    @GetMapping(value = "/permission/{id}")
    public Result<Permission> get(@PathVariable int id) {
        Permission permission = permissionRepo.findById(id).orElse(null);
        if (permission == null) {
            return Result.error(ResultCode.DATA_NOT_EXIST);
        }
        return Result.success(permission);
    }
}