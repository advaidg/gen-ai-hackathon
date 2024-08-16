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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private DemoService demoService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testGetAllUsers() {
        // Mock data
        List<User> users = Arrays.asList(
                new User(1L, "John Doe", "john.doe@example.com"),
                new User(2L, "Jane Doe", "jane.doe@example.com")
        );

        // Mock service behavior
        when(demoService.getAllUsers()).thenReturn(users);

        // Call the controller method
        List<User> result = userController.getAllUsers();

        // Assert the results
        assertEquals(users, result);
    }

    @Test
    public void testGetUserById() {
        // Mock data
        Long userId = 1L;
        User user = new User(userId, "John Doe", "john.doe@example.com");

        // Mock service behavior
        when(demoService.getUserById(userId)).thenReturn(user);

        // Call the controller method
        User result = userController.getUserById(userId);

        // Assert the results
        assertEquals(user, result);
    }

    @Test
    public void testGreeting() {
        // Mock data
        String name = "Alice";

        // Call the controller method
        String result = userController.greeting(name);

        // Assert the results
        assertEquals("Hello, " + name + "!", result);
    }

    // Example test for XSS vulnerability
    @Test
    public void testGreetingWithXSS() {
        // Mock data
        String name = "<script>alert('XSS')</script>";

        // Call the controller method
        String result = userController.greeting(name);

        // Assert the results
        // Here, we should ideally check if the response contains sanitized output,
        // or if any XSS protection mechanisms are in place.
        // This example only shows the potential vulnerability.
        assertTrue(result.contains(name));
    }
}
