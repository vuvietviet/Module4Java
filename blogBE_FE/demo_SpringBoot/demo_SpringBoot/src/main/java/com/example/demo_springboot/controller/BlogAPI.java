package com.example.demo_springboot.controller;

import com.example.demo_springboot.model.Blogs;
import com.example.demo_springboot.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/blogs")
public class BlogAPI {
    @Autowired
    BlogService blogService;

    @GetMapping
    public Page<Blogs> getPage(@RequestParam(defaultValue = "0") int page) {

        return blogService.getAll(PageRequest.of(page,5));
    }

    @PostMapping
    public Blogs save(@RequestBody Blogs blogs) {
        blogService.save(blogs);
        return blogs;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        blogService.delete(id);
        return "Deleted";
    }

    @PutMapping
    public Blogs update(@RequestBody Blogs blogs) {
        blogService.save(blogs);
        return blogs;
    }

    @GetMapping("/{idBlog}")
    public Blogs getById(@PathVariable long idBlog) {
        Blogs blogs = blogService.findById(idBlog).get();
        return blogs;
    }

    @GetMapping("/search")
    public List<Blogs> findByTitle(@RequestParam(defaultValue = "") String title){
        return blogService.findByTitle(title);
    }


    @PostMapping("/upImg")
    public String upImg(@RequestParam MultipartFile file){
        String name = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),new File("F:\\Module4\\blog_FrontEnd\\img\\" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/img/"+name;
    }
}
