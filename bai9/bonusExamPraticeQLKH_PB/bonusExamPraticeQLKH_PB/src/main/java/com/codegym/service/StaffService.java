package com.codegym.service;

import com.codegym.model.Staff;
import com.codegym.repository.IStaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    IStaffRepo iStaffRepo;

    public Page<Staff> getAll(Pageable pageable) {
        return  iStaffRepo.findAll(pageable);
    }

    public void save(Staff staff) {
        iStaffRepo.save(staff);
    }

    public void delete(long id) {
        iStaffRepo.deleteById(id);
    }

    public Optional<Staff> findById(long id) {
        return iStaffRepo.findById(id);
    }
}
