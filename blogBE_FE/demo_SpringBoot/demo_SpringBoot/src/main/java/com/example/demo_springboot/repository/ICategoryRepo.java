package com.example.demo_springboot.repository;

import com.example.demo_springboot.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepo extends CrudRepository<Category,Long> {
}
