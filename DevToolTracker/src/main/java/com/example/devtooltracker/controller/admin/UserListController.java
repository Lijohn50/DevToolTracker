package com.example.devtooltracker.controller.admin;

import com.example.devtooltracker.Model.user.User;
import com.example.devtooltracker.service.UserListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class UserListController {

    private final UserListService userListService;

    @GetMapping("/user-list")
    public String userList(Model model) {

        List<User> developers = userListService.findAll();
        System.out.println("Developers: " + developers);

        model.addAttribute("developers", userListService.findAll());
        return "list";
    }

    @GetMapping("/user-list/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        User user = userListService.findById(id);
        model.addAttribute("registrationRequest", user);
        model.addAttribute("formAction", "/admin/user-list/{id}/edit" + id);
        return "setup";
    }
}
