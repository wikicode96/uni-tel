package com.github.wikicode96.admin.controller;

import com.github.wikicode96.admin.model.User;
import com.github.wikicode96.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/all")
    String allUsers(Model model){

        User[] users = service.getAllUsers();
        model.addAttribute("users", users);

        return "users-table";
    }
}
