package com.example.devtooltracker.controller.admin;

import com.example.devtooltracker.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class DashboardController {

        private final DashboardService dashboardService;

        @GetMapping("/dashboard")
        public String dashboard(Model model) {

            model.addAttribute("isAdmin", true);
            model.addAttribute("stats", dashboardService.getAdminStats());
            //model.addAttribute("myToolsCount", dashboardService.getMyToolsCount(user.getId()));
            model.addAttribute("myPendingRequestsCount", 0);
            return "dashboard";
        }
}
