package com.zglu.controller;

import com.zglu.dao.entity.RolePermission;
import com.zglu.dao.entity.UserRole;
import com.zglu.dao.repo.PermissionRepo;
import com.zglu.dao.repo.RolePermissionRepo;
import com.zglu.dao.repo.UserRoleRepo;
import com.zglu.result.Result;
import com.zglu.result.ResultCode;
import com.zglu.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController("/user")
public class UserController {

    @Autowired
    private UserRoleRepo userRoleRepo;
    @Autowired
    private RolePermissionRepo rolePermissionRepo;
    @Autowired
    private PermissionRepo permissionRepo;

    @GetMapping(value = "/role-permission")
    public Result<RolePermission> get(String url, String method, String token) {
        Integer permissionId = permissionRepo.get(url, method);
        if (permissionId == null) {
            return Result.error(ResultCode.PERMISSION_NOT_EXIST);
        }
        Integer id = TokenUtil.parserTokenToId(token);
        if (id == null) {
            return Result.error(ResultCode.USER_TOKEN_ERROR);
        }
        List<UserRole> userRoleList = userRoleRepo.findByUserId(id);
        List<Integer> ids = userRoleList.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        List<RolePermission> rolePermissionList = rolePermissionRepo.findByRoleIdInAndPermissionId(ids, permissionId);
        if (rolePermissionList.isEmpty()) {
            return Result.error(ResultCode.USER_NOT_PERMISSION);
        }
        return Result.success(rolePermissionList.get(0));
    }
}