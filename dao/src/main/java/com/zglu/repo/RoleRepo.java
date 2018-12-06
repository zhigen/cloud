package com.zglu.repo;

import com.zglu.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends PagingAndSortingRepository<Role, Integer> {

}