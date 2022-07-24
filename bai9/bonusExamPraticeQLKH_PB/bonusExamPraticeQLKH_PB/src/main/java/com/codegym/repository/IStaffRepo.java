package com.codegym.repository;

import com.codegym.model.Staff;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IStaffRepo extends PagingAndSortingRepository<Staff, Long> {
}
