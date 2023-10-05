package com.aventure.rms.user.controller;

import com.aventure.rms.user.entity.User;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface UserController {

    List<User> findAll();

    User findUserById(int userId);

    User addUser(User theUser);

    User updateUser(User theUser);

    String deleteUser(int userId);
}
