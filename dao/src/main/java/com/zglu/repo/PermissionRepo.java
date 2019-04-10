package com.zglu.repo;

import com.zglu.entity.Permission;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends PagingAndSortingRepository<Permission, Integer> {

}