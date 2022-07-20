package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Song;
import com.codegym.service.CategoryService;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import java.io.File;
import java.io.IOException;

@Controller
public class SongController {
    @Autowired
    SongService songService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/songs")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("songs", songService.getAll());
        return modelAndView;
    }

    @GetMapping("/createForm")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("song", new Song());
        modelAndView.addObject("categories", categoryService.getAll());
        return modelAndView;
    }

    @PostMapping("/createForm")
    public ModelAndView create(@ModelAttribute Song song,
                               @RequestParam int IdCategory, @RequestParam MultipartFile fileMusic){
        String nameFile = fileMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(fileMusic.getBytes(), new File("F:\\Module4\\bai6\\BT1MusicApp\\src\\main\\webapp\\WEB-INF\\file\\" + nameFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        song.setFile(nameFile);
        ModelAndView modelAndView = new ModelAndView("redirect:/songs");
        Category category = new Category();
        category.setId(IdCategory);
        song.setCategory(category);
        songService.create(song);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("song", songService.findById(id));
        modelAndView.addObject("categories", categoryService.getAll());
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Song song, @PathVariable int id,
                             @RequestParam int IdCategory,@RequestParam MultipartFile fileMusic){
        String nameFile = fileMusic.getOriginalFilename();
        if (nameFile.equals("")){
            song.setFile(songService.findById(id).getFile());
        }else {
            song.setFile(nameFile);
        }

        try {
            FileCopyUtils.copy(fileMusic.getBytes(), new File("F:\\Module4\\bai6\\BT1MusicApp\\src\\main\\webapp\\WEB-INF\\file\\" + nameFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/songs");
        Category category = new Category();
        category.setId(IdCategory);
        song.setCategory(category);
        songService.edit(song);
        return modelAndView;
    }

    @GetMapping("/del/{id}")
    public ModelAndView del(@PathVariable("id") int id){
        songService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/songs");
        return modelAndView;
    }
}
