package com.example.springmvcday01introduction.controller;

import com.example.springmvcday01introduction.model.Student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/{id}")
    @ResponseBody
    public String student(@PathVariable int id) {

        return "Student ID = " + id;

    }

    @GetMapping("/search")
    @ResponseBody
    public String searchStudent(
            @RequestParam String name) {

        return "Searching for: " + name;

    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

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

    @GetMapping("/profile")
    public String profile(Model model) {

//        Student student =
//                new Student(
//                        "Darvin",
//                        "CSE",
//                        8.75
//                );

//        model.addAttribute("student", student);

        return "profile";
    }

}