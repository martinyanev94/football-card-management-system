package com.example.controller;

import com.example.exception.ResourceNotFoundException;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }
}
