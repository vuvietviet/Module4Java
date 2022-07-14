package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {

    @GetMapping("/home")
    public String showHome(){
        return "home";
    }


    @RequestMapping  ("/save")
    public ModelAndView save(@RequestParam("Giavi") String[] Giavi1){
        ModelAndView modelAndView1 = new ModelAndView("save");
        modelAndView1.addObject("Giavi2",Giavi1);
        return modelAndView1;
    }

}
