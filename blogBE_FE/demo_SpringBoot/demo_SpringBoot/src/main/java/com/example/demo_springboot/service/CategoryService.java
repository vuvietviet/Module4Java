package com.example.demo_springboot.service;

import com.example.demo_springboot.model.Category;
import com.example.demo_springboot.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    ICategoryRepo iCategoryRepo;

    public List<Category> getAll(){
        return (List<Category>) iCategoryRepo.findAll();
    }
    public Category findById(long id){
        return iCategoryRepo.findById(id).get();
    }
}
