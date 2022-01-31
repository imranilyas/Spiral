package com.banking.Spiral.controllers;

import com.banking.Spiral.entities.User;
import com.banking.Spiral.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin
public class UserController {

    // Service
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "{userID}")
    public User loginUser(@PathVariable("userID") Long userID) {
        return userService.getUser(userID);
    }

    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userService.postUser(user);
    }

    @PutMapping(path = "{userID}")
    public User updateUser(@PathVariable("userID") Long userID, @RequestBody User user) {
        return userService.updateUser(userID, user);
    }

    @DeleteMapping(path = {"userID"})
    public boolean deleteUser(@PathVariable("userID") Long userID) {
        return userService.deleteUser(userID);
    }
    
}
