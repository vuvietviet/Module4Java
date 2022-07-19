package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface CRUD<E> {
    void create(E e);
    void edit(Product product);
    void delete(int id);
    List<E> getAll();
}
