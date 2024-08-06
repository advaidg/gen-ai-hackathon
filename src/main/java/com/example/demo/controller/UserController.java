package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return demoService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return demoService.getUserById(id);
    }

    // Potential security vulnerability (XSS)
    @GetMapping("/greeting")
    public String greeting(@RequestParam String name) {
        return "Hello, " + name + "!"; // Vulnerable to XSS
    }
}
