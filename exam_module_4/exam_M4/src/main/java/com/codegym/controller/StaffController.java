package com.codegym.controller;

import com.codegym.model.Branch;
import com.codegym.model.Staff;
import com.codegym.service.BranchService;
import com.codegym.service.StaffService;
import com.codegym.validate.ValidateStaff;
import com.codegym.validate.ValidateStaffEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class StaffController {
    @Autowired
    BranchService branchService;

    @Autowired
    StaffService staffService;

    @Autowired
    ValidateStaff validateStaff;

    @Autowired
    ValidateStaffEdit validateStaffEdit;

    @ModelAttribute(name = "staff")
    public Staff staff() {
        return new Staff();
    }

    @ModelAttribute(name = "branchs")
    public List<Branch> branchs() {
        return branchService.getAll();
    }

    @GetMapping("/staffs")
    public ModelAndView show(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String message) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("staffs", staffService.getAll(PageRequest.of(page, 10, Sort.by("age"))));
        modelAndView.addObject("message", message);
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("staff") Staff staff,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        validateStaff.validate(staff,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        staffService.save(staff);
        ModelAndView modelAndView = new ModelAndView("redirect:/staffs");
        redirectAttributes.addAttribute("message","Create success");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Optional<Staff> staff = staffService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("staff", staff);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@Valid @ModelAttribute("staff") Staff staff,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        validateStaffEdit.validate(staff,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("edit");
            return modelAndView;
        }
        staffService.save(staff);
        ModelAndView modelAndView = new ModelAndView("redirect:/staffs");
        redirectAttributes.addAttribute("message","Edit success");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Long id) {
        Optional<Staff> staff = staffService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("staff", staff);
        return modelAndView;
    }


    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id,RedirectAttributes redirectAttributes) {
        staffService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/staffs");
        redirectAttributes.addAttribute("message","Delete success");
        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView showDetails(@PathVariable Long id) {
        Optional<Staff> staff = staffService.findById(id);
        ModelAndView modelAndView = new ModelAndView("details");
        modelAndView.addObject("staff", staff);
        return modelAndView;
    }
}
