package com.example.devtooltracker.controller.admin;

import com.example.devtooltracker.model.Tool;
import com.example.devtooltracker.service.ToolDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class ToolDetailsController {

    private final ToolDetailsService toolDetailsService;

    @GetMapping("/tool-details/{id}")
    public String toolDetails(Model model, @PathVariable int id) {

        model.addAttribute("tool", toolDetailsService.getToolDetails(id));
        return "toolDetail";
    }
}
