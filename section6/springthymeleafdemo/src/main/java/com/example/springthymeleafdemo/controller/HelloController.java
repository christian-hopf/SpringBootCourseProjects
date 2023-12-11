package com.example.springthymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/showform")
    public String showForm() {
        return "hello-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "hello";
    }

    @PostMapping("/processFormThree")
    public String greetStudent(@RequestParam("studentName") String studentName, Model model) {
        studentName = studentName.toUpperCase();
        String greeting = "Hello " + studentName + ", this is processFormThree";
        model.addAttribute("message", greeting);
        return "hello";
    }

}
