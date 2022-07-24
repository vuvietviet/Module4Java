package com.codegym.service;

import com.codegym.model.Deparment;
import com.codegym.repository.IDeparmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeparmentService {
    @Autowired
    IDeparmentRepo iDeparmentRepo;

    public List<Deparment> getAll(){
        return (List<Deparment>) iDeparmentRepo.findAll();
    }
    public Deparment findById(long id){
        return iDeparmentRepo.findById(id).get();
    }
}
