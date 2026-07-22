package com.example.springmvcstudentregistrationportal.controller;

import com.example.springmvcstudentregistrationportal.model.Student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/register")
    public String registerStudent(
            @Valid @ModelAttribute Student student,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        model.addAttribute("student", student);

        return "success";
    }

}
