package com.zglu.repo;

import com.zglu.entity.Permission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends PagingAndSortingRepository<Permission, Integer> {
    @Query(value = "select id from zglu_permission where ?1 like url and length(?1)-length(replace(?1,'/',''))=length(url)-length(replace(url,'/','')) and ?2=method limit 0,1",nativeQuery = true)
    Integer get(String url,String method);
}