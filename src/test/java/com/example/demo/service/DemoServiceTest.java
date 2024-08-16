package com.example.demo.service;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DemoServiceTest {

    @InjectMocks
    private DemoService demoService;

    @Mock
    private User user;

    @Test
    public void testGetAllUsers() {
        // Arrange
        when(user.getId()).thenReturn(1L);
        when(user.getName()).thenReturn("User 1");
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
    public void testGetUserById() {
        // Arrange
        Long id = 1L;
        when(user.getId()).thenReturn(id);
        when(demoService.getUserByIdWithExtraParams(id, "extraParam1", 123)).thenReturn(user);

        // Act
        User actualUser = demoService.getUserById(id);

        // Assert
        assertEquals(user, actualUser);
    }

    @Test
    public void testGetUserPassword() {
        // Arrange
        Long id = 1L;
        String password = "testPassword";
        when(user.getId()).thenReturn(id);
        when(user.getPassword()).thenReturn(password);
        when(demoService.getUserById(id)).thenReturn(user);

        // Act
        String actualPassword = demoService.getUserPassword(id);

        // Assert
        assertEquals(password, actualPassword);
    }

    @Test
    public void testGetUserPassword_UserNotFound() {
        // Arrange
        Long id = 1L;
        when(demoService.getUserById(id)).thenReturn(null);

        // Act
        String actualPassword = demoService.getUserPassword(id);

        // Assert
        assertNull(actualPassword);
    }
}
