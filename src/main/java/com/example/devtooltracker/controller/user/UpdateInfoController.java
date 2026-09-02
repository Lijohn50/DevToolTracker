package com.example.devtooltracker.controller.user;

import com.example.devtooltracker.dto.UserPassUpdate;
import com.example.devtooltracker.model.User;
import com.example.devtooltracker.service.user.UpdateInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UpdateInfoController {

    private final UpdateInfoService updateInfoService;

    @GetMapping("/update-info")
    public String getInfo(Model model, Authentication authentication) {

        model.addAttribute("formAction", "/user/update-info");
        model.addAttribute("registrationRequest", updateInfoService.getUser(authentication.getName()));
        return "setup";
    }
    @PostMapping("/update-info")
    public String updateInfo(@ModelAttribute User user){

        updateInfoService.updateInfo(user);
        return "redirect:/user/dashboard";
    }
    @PostMapping("/update-password")
    public String updatePassword(@ModelAttribute UserPassUpdate password, Authentication authentication) {

        updateInfoService.updatePassword(authentication.getName(), password);
        return "redirect:/user/dashboard";
    }
}
