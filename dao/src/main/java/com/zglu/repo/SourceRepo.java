package com.zglu.repo;

import com.zglu.entity.Source;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepo extends PagingAndSortingRepository<Source, Integer> {

}