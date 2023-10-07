package com.example.autoconfiguration.controller;


import com.example.autoconfiguration.model.User;
import com.example.autoconfiguration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/user")
@RestController
public class UserController {


    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("getUser/{userId}")
    public User getUserById(@PathVariable long userId) {
        return service.getUserById(userId);
    }

    @PostMapping("createUser")
    public User addUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping("updateUser")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("deleteUser/{userId}")
    public Boolean deleteUser(@PathVariable long userId) {
        return service.deleteUser(userId);
    }

}
