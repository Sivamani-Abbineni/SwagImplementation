package com.example.swag.controller;

import com.example.swag.entity.User;
import com.example.swag.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User API", description = "User Management Endpoints")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @Operation(summary = "Get all users", description = "Retrieve a list of all users.")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    @Operation(summary = "Add a new user", description = "Create and store a new user in the database.")
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user", description = "Remove a user by ID.")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
