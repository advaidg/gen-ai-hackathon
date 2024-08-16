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
        List<User> users = Arrays.asList(new User(1L, "John Doe"), new User(2L, "Jane Doe"));
        when(demoService.getAllUsers()).thenReturn(users);

        // Call the controller method
        List<User> result = userController.getAllUsers();

        // Assert the result
        assertEquals(users, result);
        verify(demoService, times(1)).getAllUsers();
    }

    @Test
    public void testGetUserById() {
        // Mock data
        Long userId = 1L;
        User user = new User(userId, "John Doe");
        when(demoService.getUserById(userId)).thenReturn(user);

        // Call the controller method
        User result = userController.getUserById(userId);

        // Assert the result
        assertEquals(user, result);
        verify(demoService, times(1)).getUserById(userId);
    }

    @Test
    public void testGreeting() {
        // Mock data
        String name = "Test User";
        String expectedGreeting = "Hello, " + name + "!";

        // Call the controller method
        String result = userController.greeting(name);

        // Assert the result
        assertEquals(expectedGreeting, result);
    }

    // Test for potential XSS vulnerability in greeting method
    @Test
    public void testGreetingWithXSS() {
        // Mock data
        String maliciousName = "<script>alert('XSS')</script>";

        // Call the controller method
        String result = userController.greeting(maliciousName);

        // Assert the result contains the malicious script (indicating vulnerability)
        assertTrue(result.contains("<script>alert('XSS')</script>"));
    }
}
