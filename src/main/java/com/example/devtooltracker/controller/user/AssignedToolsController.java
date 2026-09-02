package com.example.devtooltracker.controller.user;

import com.example.devtooltracker.service.user.AssignedToolsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class AssignedToolsController {

    private final AssignedToolsService assignedToolsService;

    @GetMapping("/assigned-tools")
    public String assignedTools(Model model, Authentication authentication) {

        model.addAttribute("assignedTools", assignedToolsService.getAssignedTools(authentication.getName()) );
        return "toolList";
    }
}
