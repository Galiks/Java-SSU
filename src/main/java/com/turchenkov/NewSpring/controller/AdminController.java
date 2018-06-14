package com.turchenkov.NewSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/adminHome")
    public String homeAdmin(Model model) {
        return "adminHome";
    }
}
