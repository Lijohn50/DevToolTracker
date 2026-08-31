package com.example.devtooltracker.controller;

import com.example.devtooltracker.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/login")
public class LoginController {

    @GetMapping("/form")
    public String loginForm(Model model) {

        model.addAttribute("loginRequest", new User());
        return "login";
    }
}
