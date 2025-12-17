package com.example.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class User {

    @NotBlank(message = "Username must not be empty")
    private String username;

    @Email(message = "Email should be valid")
    private String email;

    // Getters and Setters
}
