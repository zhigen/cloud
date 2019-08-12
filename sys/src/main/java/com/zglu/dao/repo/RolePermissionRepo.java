package com.zglu.dao.repo;

import com.zglu.dao.entity.RolePermission;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionRepo extends PagingAndSortingRepository<RolePermission, Integer> {
    List<RolePermission> findByRoleIdInAndPermissionId(List<Integer> ids, int permissionId);
}