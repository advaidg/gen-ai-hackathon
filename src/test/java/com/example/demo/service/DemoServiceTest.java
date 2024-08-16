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

@ExtendWith(MockitoExtension.class)
public class DemoServiceTest {

    @InjectMocks
    private DemoService demoService;

    @Mock
    private User user;

    @Test
    void getAllUsers() {
        // Arrange
        List<User> expectedUsers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId((long) i);
            user.setName("User " + i);
            expectedUsers.add(user);
        }

        // Act
        List<User> actualUsers = demoService.getAllUsers();

        // Assert
        assertEquals(expectedUsers, actualUsers);
    }

    @Test
    void getUserById() {
        // Arrange
        Long id = 1L;
        Mockito.when(demoService.getUserByIdWithExtraParams(id, "extraParam1", 123)).thenReturn(user);

        // Act
        User actualUser = demoService.getUserById(id);

        // Assert
        assertEquals(user, actualUser);
    }

    @Test
    void getUserPassword() {
        // Arrange
        Long id = 1L;
        Mockito.when(demoService.getUserById(id)).thenReturn(user);
        Mockito.when(user.getPassword()).thenReturn("password123");

        // Act
        String password = demoService.getUserPassword(id);

        // Assert
        assertEquals("password123", password);
    }

    @Test
    void getUserPassword_UserNotFound() {
        // Arrange
        Long id = 1L;
        Mockito.when(demoService.getUserById(id)).thenReturn(null);

        // Act
        String password = demoService.getUserPassword(id);

        // Assert
        assertNull(password);
    }

    @Test
    void getUserByUsername() {
        // Arrange
        String username = "testuser";
        Mockito.when(demoService.getUserByUsername(username)).thenReturn(user);

        // Act
        User actualUser = demoService.getUserByUsername(username);

        // Assert
        assertEquals(user, actualUser);
    }

    // ... (Add more tests for other methods, addressing code smells and security issues)
}
