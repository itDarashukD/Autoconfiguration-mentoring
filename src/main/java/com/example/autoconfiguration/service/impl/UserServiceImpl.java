package com.example.autoconfiguration.service.impl;

import com.example.autoconfiguration.dao.UserDao;
import com.example.autoconfiguration.model.User;
import com.example.autoconfiguration.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(long userId) {
        final User userById = userDao.getUserById(userId);

        return Optional.ofNullable(userById)
	       .orElseThrow(() -> new IllegalArgumentException(String.format(
		      "user with userId %s did not found",
		      userId)));
    }

    @Override
    public User createUser(User user) {
        userDao.createUser(user);

        return user;
    }

    @Override
    public User updateUser(User user) {
        userDao.updateUser(user);

        return user;
    }

    @Override
    public boolean deleteUser(long userId) {
        userDao.deleteUser(userId);

        return true;
    }

}
