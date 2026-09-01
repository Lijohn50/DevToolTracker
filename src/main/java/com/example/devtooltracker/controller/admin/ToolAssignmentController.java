package com.example.devtooltracker.controller.admin;

import com.example.devtooltracker.service.AssignmentService;
import com.example.devtooltracker.service.ToolDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ToolAssignmentController {

    private final ToolDetailsService toolDetailsService;
    private final AssignmentService assignmentService;

    @GetMapping("/tools/{id}/assign")
    public String toolAssignment(@PathVariable int id, Model model) {

        model.addAttribute("tool", toolDetailsService.getToolDetails(id));
        return "toolDetail";
    }
    @PostMapping("/tools/{id}/assign")
    public String assignTool(@PathVariable int id, @RequestParam int developerId) {

        assignmentService.addAssignment(id, developerId);
        return "redirect:/admin/tools/{id}/assign";
    }
}
