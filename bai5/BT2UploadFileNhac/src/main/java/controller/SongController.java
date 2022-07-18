package controller;

import model.Song;
import model.SongForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ISongService;
import service.SongService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class SongController {
    private final ISongService songService = new SongService();


    @GetMapping("/song")
    public String index(Model model) {
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("list", new String[]{"nhac tre","nhac tru tinh","nhac xua"});
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveSong(@ModelAttribute SongForm songForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = songForm.getFile();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getFile().getBytes(), new File("F:\\Module4\\bai5\\BT2UploadFileNhac\\src\\main\\webapp\\WEB-INF\\songList\\" + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if ((fileName.contains(".mp3")) || (fileName.contains(".wav")) ||(fileName.contains(".ogg")) || (fileName.contains(".m4p")) ){
            Song song = new Song(songForm.getId(), songForm.getName(),
                    songForm.getSinger(),songForm.getCategory(), fileName);
            songService.save(song);
            ModelAndView modelAndView = new ModelAndView("/create");
            modelAndView.addObject("songForm", songForm);
            modelAndView.addObject("message", "Created new song successfully !");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/create");
            redirectAttributes.addFlashAttribute("message", "Expression of file is error. Please enter again!");
            return modelAndView;
        }

    }
}
