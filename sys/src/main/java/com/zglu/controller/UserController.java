package com.zglu.controller;

import com.zglu.entity.RolePermission;
import com.zglu.entity.UserRole;
import com.zglu.repo.PermissionRepo;
import com.zglu.repo.RolePermissionRepo;
import com.zglu.repo.UserRoleRepo;
import com.zglu.result.Result;
import com.zglu.result.ResultCode;
import com.zglu.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserRoleRepo userRoleRepo;
    @Autowired
    private RolePermissionRepo rolePermissionRepo;
    @Autowired
    private PermissionRepo permissionRepo;

    @GetMapping(value = "/role-permission")
    public Result<RolePermission> get(String url,String method,String token){
        Integer permissionId = permissionRepo.get(url,method);
        if (permissionId == null) {
            return Result.error(ResultCode.PERMISSION_NOT_EXIST);
        }else {
            Integer id = get(token);
            if (id == null) {
                return Result.error(ResultCode.USER_TOKEN_ERROR);
            }
            List<UserRole> userRoleList = userRoleRepo.findByUserId(id);
            List<Integer> ids = userRoleList.stream().map(m -> m.getRoleId()).collect(Collectors.toList());
            List<RolePermission> rolePermissionList = rolePermissionRepo.findByRoleIdInAndPermissionId(ids,permissionId);
            if (rolePermissionList.isEmpty()) {
                return Result.error(ResultCode.USET_NOT_PERMISSION);
            }
            return Result.success(rolePermissionList.get(0));
        }
    }

    public Integer get(String token){
        try {
            Map map = TokenUtil.parserToken(token);
            Integer userId = (Integer)map.get("userId");
            return userId;
        } catch (Exception e) {
            return Integer.parseInt(token);
        }
    }
}