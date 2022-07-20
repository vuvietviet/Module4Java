package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface CRUD<E> {
    void create(E e);
    void edit(Song song);
    void delete(int id);
    List<E> getAll();
}
