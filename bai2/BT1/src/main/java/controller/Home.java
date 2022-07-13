package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {

    @GetMapping("/home")
    public String showHome(){
        return "home";
    }

    @PostMapping ("/create")
    public String create(@RequestParam int usd, int tigia, Model model ){
        model.addAttribute("vnd",usd * tigia);
        return "create";
    }

}
