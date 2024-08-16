package com.example.demo.service;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DemoServiceTest {

    @InjectMocks
    private DemoService demoService;

    @Mock
    private User user;

    @Test
    void getAllUsers() {
        List<User> expectedUsers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId((long) i);
            user.setName("User " + i);
            expectedUsers.add(user);
        }
        List<User> actualUsers = demoService.getAllUsers();
        assertEquals(expectedUsers, actualUsers);
    }

    @Test
    void getUserById() {
        Long id = 1L;
        when(demoService.getUserByIdWithExtraParams(id, "extraParam1", 123)).thenReturn(user);
        User actualUser = demoService.getUserById(id);
        assertEquals(user, actualUser);
    }

    @Test
    void getUserPassword() {
        Long id = 1L;
        when(demoService.getUserById(id)).thenReturn(user);
        when(user.getPassword()).thenReturn("password123");
        String actualPassword = demoService.getUserPassword(id);
        assertEquals("password123", actualPassword);
    }

    @Test
    void getUserPassword_UserNotFound() {
        Long id = 1L;
        when(demoService.getUserById(id)).thenReturn(null);
        String actualPassword = demoService.getUserPassword(id);
        assertNull(actualPassword);
    }

    @Test
    void getUserByUsername() {
        String username = "testuser";
        when(demoService.getUserByUsername(username)).thenReturn(user);
        User actualUser = demoService.getUserByUsername(username);
        assertEquals(user, actualUser);
    }

    // Test cases for other methods can be added here...
}
