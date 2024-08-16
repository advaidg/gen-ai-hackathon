package com.example.demo.service;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DemoServiceTest {

    @InjectMocks
    private DemoService demoService;

    @Test
    void getAllUsers() {
        List<User> users = demoService.getAllUsers();
        assertEquals(10, users.size());
        for (int i = 0; i < 10; i++) {
            assertEquals((long) i, users.get(i).getId());
            assertEquals("User " + i, users.get(i).getName());
        }
    }

    @Test
    void getUserById() {
        User user = new User();
        user.setId(1L);
        user.setName("User 1");
        when(demoService.getUserByIdWithExtraParams(1L, "extraParam1", 123)).thenReturn(user);

        User retrievedUser = demoService.getUserById(1L);

        assertEquals(user, retrievedUser);
        verify(demoService).getUserByIdWithExtraParams(1L, "extraParam1", 123);
    }

    @Test
    void getUserPassword() {
        User user = new User();
        user.setId(1L);
        user.setPassword("password123");
        when(demoService.getUserById(1L)).thenReturn(user);

        String password = demoService.getUserPassword(1L);

        assertEquals("password123", password);
    }

    @Test
    void getUserPassword_UserNotFound() {
        when(demoService.getUserById(2L)).thenReturn(null);

        String password = demoService.getUserPassword(2L);

        assertNull(password);
    }

    @Test
    void getUsersByQuery() {
        // Test for SQL injection vulnerability
        // This test should fail if the implementation is vulnerable
        List<User> users = demoService.getUsersByQuery("'; DROP TABLE users; --");
        // Assertions should be made based on the expected behavior
        // For example, assert that the list is empty or contains specific users
        // based on the database state.
        // ...
    }

    @Test
    void getUserByUsername() {
        // Test for SQL injection vulnerability
        // This test should fail if the implementation is vulnerable
        User user = demoService.getUserByUsername("'; DROP TABLE users; --");
        // Assertions should be made based on the expected behavior
        // For example, assert that the user is null or contains specific data
        // based on the database state.
        // ...
    }

    // Test cases for other methods can be added as needed
}
