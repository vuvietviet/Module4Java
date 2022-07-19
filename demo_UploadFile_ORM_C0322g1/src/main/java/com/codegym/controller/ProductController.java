package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.CategoryService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/products")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products", productService.getAll());
        return modelAndView;
    }

    @GetMapping("/createForm")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("categories", categoryService.getAll());
        return modelAndView;
    }

    @PostMapping("/createForm")
    public ModelAndView create(@ModelAttribute Product product,
                             @RequestParam int IdCategory,@RequestParam MultipartFile file){
        String nameImg = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File("F:\\Module4\\demo_UploadFile_ORM_C0322g1\\src\\main\\webapp\\WEB-INF\\img\\" + nameImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setImg("/img/" + nameImg);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        Category category = new Category();
        category.setId(IdCategory);
        product.setCategory(category);
        productService.create(product);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product", productService.findById(id));
        modelAndView.addObject("categories", categoryService.getAll());
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Product product, @PathVariable int id,
                             @RequestParam int IdCategory,@RequestParam MultipartFile file){
        String nameImg = file.getOriginalFilename();
        if (nameImg.equals("")){
            product.setImg(productService.findById(id).getImg());
        }else {
            product.setImg("/img/" + nameImg);
        }

        try {
            FileCopyUtils.copy(file.getBytes(), new File("F:\\Module4\\demo_UploadFile_ORM_C0322g1\\src\\main\\webapp\\WEB-INF\\img\\" + nameImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        Category category = new Category();
        category.setId(IdCategory);
        product.setCategory(category);
        productService.edit(product);
        return modelAndView;
    }

    @GetMapping("/del/{id}")
    public ModelAndView del(@PathVariable("id") int id){
        productService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        return modelAndView;
    }
}
