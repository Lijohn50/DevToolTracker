package com.example.devtooltracker.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class RequestToolController {

    @GetMapping("/request-tool")
    public String requestTool() {

        return "comingSoon";
    }
}
