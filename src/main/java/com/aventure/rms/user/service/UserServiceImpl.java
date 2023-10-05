package com.aventure.rms.user.service;

import com.aventure.rms.user.entity.User;
import com.aventure.rms.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//defined a class to implement the user-service interface
@Service
public class UserServiceImpl implements UserService{

    //defined user repository field
    private final UserRepository userRepository;

    //a constructor injection of userRepository interface
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //method definition to find all the users
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    //method definition to find a user by id
    @Override
    public User findUserById(int theId) {

        //storing the user in a variable - result
        Optional<User> result = userRepository.findById(theId);

        //a conditional control statement to throw an exception, if the result is not a user.
        if(result.isEmpty()){
            throw new RuntimeException("User "+theId+" not found.");
        }
        else{
            return result.get();
        }
    }

    //method definition to save a user
    @Override
    public User saveUser(User theUser) {
        return userRepository.save(theUser);
    }

    //method definition to delete a user by id
    @Override
    public void deleteUserById(int theId) {
        userRepository.deleteById(theId);
    }
}
