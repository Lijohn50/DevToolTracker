package com.example.devtooltracker.controller.user;

import com.example.devtooltracker.service.DashboardService;
import com.example.devtooltracker.service.user.UserDashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserDashboardController {

    private final UserDashboardService dashboardService;

    @GetMapping("/dashboard")
    public String userDashboard(Model model, Authentication authentication) {

        String email = authentication.getName();

        model.addAttribute("myToolsCount", dashboardService.getMyToolsCount(email));
        model.addAttribute("nextRenewal", dashboardService.getNextRenewal(email));
        return "dashboard";
    }
}
