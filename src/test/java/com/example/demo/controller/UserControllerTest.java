package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private DemoService demoService;

    @InjectMocks
    private UserController userController;

    @Test
    void getAllUsers() {
        // Arrange
        List<User> users = Arrays.asList(new User(1L, "John Doe"), new User(2L, "Jane Doe"));
        when(demoService.getAllUsers()).thenReturn(users);

        // Act
        List<User> result = userController.getAllUsers();

        // Assert
        assertEquals(users, result);
        verify(demoService, times(1)).getAllUsers();
    }

    @Test
    void getUserById() {
        // Arrange
        User user = new User(1L, "John Doe");
        when(demoService.getUserById(1L)).thenReturn(user);

        // Act
        User result = userController.getUserById(1L);

        // Assert
        assertEquals(user, result);
        verify(demoService, times(1)).getUserById(1L);
    }

    @Test
    void greeting() {
        // Act
        String result = userController.greeting("John Doe");

        // Assert
        assertEquals("Hello, John Doe!", result);
    }

    // Test for potential XSS vulnerability in greeting()
    @Test
    void greeting_XSS_Vulnerability() {
        // Arrange
        String name = "<script>alert('XSS attack!');</script>";

        // Act
        String result = userController.greeting(name);

        // Assert
        // The result should contain the malicious script
        assertTrue(result.contains("<script>alert('XSS attack!');</script>"));
    }
}
