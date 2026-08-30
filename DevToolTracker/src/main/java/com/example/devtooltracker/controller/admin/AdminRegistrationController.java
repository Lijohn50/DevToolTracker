package com.example.devtooltracker.controller.admin;

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
@RequestMapping("/admin")
public class AdminRegistrationController {

    private final RegistrationService registrationService;

    @GetMapping("/login")
    public String loginForm(Model model) {

        model.addAttribute("loginRequest",new User());
        return "login";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {

        model.addAttribute("registrationRequest", new User());
        model.addAttribute("formAction", "/admin/registration");
        return "setup";
    }
    @PostMapping("/registration")
    public String registration(@ModelAttribute User user) {

        registrationService.saveAdmin(user);
        return "redirect:/login/form";
    }
}
