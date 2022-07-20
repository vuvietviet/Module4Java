package com.codegym.service;

import com.codegym.dao.CategoryDao;
import com.codegym.model.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public List<Category> getAll(){
        return categoryDao.getList();
    }
}
