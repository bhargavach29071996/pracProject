package com.aventure.rms.user.service;

import com.aventure.rms.user.entity.User;
import java.util.List;

// defined user-service interface
public interface UserService {

    //method declaration to find all the users
    List<User> findAllUsers();
    //method declaration to find a user by id
    User findUserById(int theId);

    //method declaration to save a user
    User saveUser(User theUser);

    //method declaration to delete a user by id
    void deleteUserById(int theId);
}
