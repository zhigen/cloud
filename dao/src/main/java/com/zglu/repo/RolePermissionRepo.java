package com.zglu.repo;

import com.zglu.entity.RolePermission;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionRepo extends PagingAndSortingRepository<RolePermission, Integer> {
    List<RolePermission> findByRoleIdInAndPermissionId(List<Integer> ids,int permissionId);
}