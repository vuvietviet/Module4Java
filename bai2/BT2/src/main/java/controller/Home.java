package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {
    String[] english = {"hello","fish","sky"};
    String[] tiengViet = {"xin chao","ca","bau troi"};
    @GetMapping("/home")
    public String showHome(){
        return "home";
    }

    @PostMapping ("/translate")
    public String create(@RequestParam String ta, Model model ){
        String tv = "Khong tim thay";
        for (int i = 0; i < english.length; i++) {
            if (english[i].equals(ta)) {
                tv = tiengViet[i];
            }
        }
        model.addAttribute("tv",tv);
        return "translate";
    }

}
