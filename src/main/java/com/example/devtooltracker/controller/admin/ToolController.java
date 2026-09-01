package com.example.devtooltracker.controller.admin;

import com.example.devtooltracker.model.Tool;
import com.example.devtooltracker.service.ToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ToolController {

    private final ToolService toolService;

    @GetMapping("/add-tools")
    public String toolForm(Model model) {

        model.addAttribute("tool", new Tool());
        model.addAttribute("formAction", "/admin/add-tools");
        return "toolForm";
    }
    @GetMapping("/tools-list")
    public String toolList(Model model) {

        model.addAttribute("tools", toolService.findAll());
        return "toolList";
    }
    @PostMapping("/add-tools")
    public String addTools(@ModelAttribute Tool tool) {

        toolService.addTool(tool);
        return "redirect:/admin/add-tools";
    }

    @GetMapping("/tools/{id}/edit")
    public String toolDetails(Model model, @PathVariable int id) {

        model.addAttribute("tool", toolService.findById(id));
        return "toolForm";
    }
    @PostMapping("/tools/{id}/edit")
    public String editTool(@ModelAttribute Tool tool, @PathVariable int id) {

        toolService.updateTool(tool);
        return "redirect:/admin/tools-list";
    }
    @GetMapping("/tools/{id}/delete")
    public String deleteTool(Model model, @PathVariable int id) {

        model.addAttribute("tool", new Tool());
        toolService.deleteTool(id);
        return "redirect:/admin/tools-list";
    }
}
