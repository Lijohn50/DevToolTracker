package com.example.devtooltracker.controller.user;

import com.example.devtooltracker.Model.user.User;
import com.example.devtooltracker.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRegistrationController {

    private final RegistrationService registrationService;

    @GetMapping("/login")
    public String loginForm(Model model) {

        model.addAttribute("loginRequest",new User());
        return "login";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {

        model.addAttribute("registrationRequest", new User());
        model.addAttribute("formAction", "/user/registration");
        return "setup";
    }
    @PostMapping("/registration")
    public String registration(@ModelAttribute User user) {

        registrationService.saveUser(user);
        return "redirect:/login/form";
    }
}
