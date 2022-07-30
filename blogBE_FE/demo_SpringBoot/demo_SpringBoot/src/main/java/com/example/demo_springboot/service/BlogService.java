package com.example.demo_springboot.service;

import com.example.demo_springboot.model.Blogs;
import com.example.demo_springboot.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    IBlogRepo iBlogRepo;

    public Page<Blogs> getAll(Pageable pageable) {
        return  iBlogRepo.findAll(pageable);
    }
    public Page<Blogs> getAllByTitle(Pageable pageable, String title) {
        return  iBlogRepo.findByTitleContaining(pageable,title);
    }


    public Blogs save(Blogs blogs) {
        return iBlogRepo.save(blogs);
    }

    public void delete(long id) {
        iBlogRepo.deleteById(id);
    }

    public Optional<Blogs> findById(long id) {
        return iBlogRepo.findById(id);
    }

    public List<Blogs> findByTitle(String title) {
        return iBlogRepo.findAllByTitleContaining(title);
    }

}
