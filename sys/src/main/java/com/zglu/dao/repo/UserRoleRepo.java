package com.zglu.dao.repo;

import com.zglu.dao.entity.UserRole;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepo extends PagingAndSortingRepository<UserRole, Integer> {
    List<UserRole> findByUserId(Integer userId);
}