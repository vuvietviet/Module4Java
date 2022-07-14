package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {

    @GetMapping("/home")
    public String showHome(){
        return "home";
    }


    @RequestMapping  ("/save")
    public ModelAndView save(@RequestParam("cal") String cal,
                             @RequestParam("num1") int num1,
                             @RequestParam("num2") int num2){
        float result = 0;
        String str = null;
        switch (cal) {
            case "+":
                str = "add";
                result = num1 + num2;
                break;
            case "-":
                str = "sub";
                result = num1 - num2;
                break;
            case "*":
                str = "mul";
                result = num1 * num2;
                break;
            case "/":
                str = "div";
                result = num1 / num2;
                break;
        }
        ModelAndView modelAndView1 = new ModelAndView("home");
        modelAndView1.addObject("result",result);
        modelAndView1.addObject("str",str);
        return modelAndView1;
    }

}
