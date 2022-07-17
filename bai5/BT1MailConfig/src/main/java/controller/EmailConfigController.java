package controller;

import dao.MailConfigDao;
import model.MailConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@RequestMapping("mailConfig")
public class EmailConfigController {

    @GetMapping
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("mailConfig",MailConfigDao.mailConfig);
        modelAndView.addObject("languagesArray", new String[]{"English","Vietnamese","Japanese","Chinese"});
        modelAndView.addObject("pageSizesArray", new String[]{"5","10","15","25","50","100"});
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView submit(@ModelAttribute("mailConfig") MailConfig mailConfig) {
        MailConfigDao.mailConfig = mailConfig;
       ModelAndView modelAndView = new ModelAndView("/create");
       modelAndView.addObject("mailConfig",MailConfigDao.mailConfig);
        return modelAndView;
    }
}
