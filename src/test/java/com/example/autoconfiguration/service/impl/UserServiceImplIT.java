package com.example.autoconfiguration.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.example.autoconfiguration.AbstractTestSupporter;
import com.example.autoconfiguration.model.User;
import com.example.autoconfiguration.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("developing")
class UserServiceImplIT extends AbstractTestSupporter {


    @Autowired
    private UserService userService;

    @Test
    void getUserById() {
        final User userById = userService.getUserById(1L);

        assertNotNull(userById.getName());
        assertNotNull(userById.getEmail());
    }

    @Test
    void createUser() {
        assertFalse(isExistInDB(userWithName444.getId()));

        final User createdUser = userService.createUser(userWithName444);

         assertEquals(createdUser.getName(),userWithName444.getName());
         assertEquals(createdUser.getEmail(),userWithName444.getEmail());
         assertTrue(createdUser.getId() != 0);
    }

    @Test
    void updateUser() {
        final User initialUserFromBb = getUserByIdJdbc(1L).get();

        initialUserFromBb.setName("updatedUserName");
        initialUserFromBb.setEmail("updatedUserEmail");

        final User updatedUser = userService.updateUser(initialUserFromBb);

        assertEquals(updatedUser.getId(),initialUserFromBb.getId());
        assertEquals(updatedUser.getName(),initialUserFromBb.getName());
        assertEquals(updatedUser.getEmail(),initialUserFromBb.getEmail());
    }

    @Test
    void deleteUser() {
        final User userToDelete = getUserByIdJdbc(2L).get();
        assertNotNull(userToDelete);

        final boolean isDeleted = userService.deleteUser(userToDelete.getId());
        assertTrue(isDeleted);

        assertFalse(isExistInDB(userToDelete.getId()));
    }
}