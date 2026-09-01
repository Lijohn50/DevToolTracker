package com.example.devtooltracker.controller.admin;

import com.example.devtooltracker.service.AssignmentService;
import com.example.devtooltracker.service.UserListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class UserDetailController {

    private final UserListService userListService;
    private final AssignmentService assignmentService;

    @GetMapping("/user-details/{id}")
    public String userDetails(Model model, @PathVariable int id) {

        model.addAttribute("developer", userListService.findById(id));
        model.addAttribute("assignments", assignmentService.findByUser(id));
        return "userDetails";
    }
}
