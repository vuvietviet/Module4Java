package com.codegym.repository;

import com.codegym.model.Staff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IStaffRepo extends PagingAndSortingRepository<Staff, Long> {
    List<Staff> findByNameContaining( String name);
}
