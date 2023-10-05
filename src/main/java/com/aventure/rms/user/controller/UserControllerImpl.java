package com.aventure.rms.user.controller;

import com.aventure.rms.user.entity.User;
import com.aventure.rms.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// defined a class for user controller
@RestController
@RequestMapping("/user")
public class UserControllerImpl {

    // defined user service field
    private UserService userService;

    // a constructor injection of userService interface
    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    // exposed "/users" to return a list of users
    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAllUsers();
    }

    // added mapping to GET /users/{userId} - finding a user by user id
    @GetMapping("/users/{userId}")
    public User findUserById(@PathVariable int userId) {

        User theUser = userService.findUserById(userId);

        if (theUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }
        return theUser;
    }

    // added mapping for POST /users - add new user
    @PostMapping("/users")
    public User addUser(@RequestBody User theUser) {
        // setting id to 0, just in case they pass an id in JSON, to save a user instead of update
        theUser.setId(0);

        return userService.saveUser(theUser);
    }

    // add mapping for PUT /users - update existing user
    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser) {
        return userService.saveUser(theUser);
    }

    // add mapping for DELETE /users/{userId} - delete user
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {

        User tempUser = userService.findUserById(userId);

        // throw exception if null
        if (tempUser == null) {
            throw new RuntimeException("user id not found - " + userId);
        }

        userService.deleteUserById(userId);

        return "Deleted user id - " + userId;
    }
}
