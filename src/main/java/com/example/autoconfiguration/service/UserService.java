package com.example.autoconfiguration.service;


import com.example.autoconfiguration.model.User;

public interface UserService {

    User getUserById(long userId);

    User createUser(User user);

    User updateUser(User user);

    boolean deleteUser(long userId);

}
