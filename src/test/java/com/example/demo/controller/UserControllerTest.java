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
        List<User> mockUsers = Arrays.asList(new User(1L, "John Doe"), new User(2L, "Jane Doe"));
        when(demoService.getAllUsers()).thenReturn(mockUsers);

        List<User> result = userController.getAllUsers();

        assertEquals(mockUsers, result);
        verify(demoService, times(1)).getAllUsers();
    }

    @Test
    public void testGetUserById() {
        User mockUser = new User(1L, "John Doe");
        when(demoService.getUserById(1L)).thenReturn(mockUser);

        User result = userController.getUserById(1L);

        assertEquals(mockUser, result);
        verify(demoService, times(1)).getUserById(1L);
    }

    @Test
    public void testGreeting() {
        String name = "Alice";
        String expectedGreeting = "Hello, " + name + "!";
        String result = userController.greeting(name);

        assertEquals(expectedGreeting, result);
    }

    // Test for XSS vulnerability in greeting method
    @Test
    public void testGreetingWithXSSInput() {
        String maliciousName = "<script>alert('XSS attack!');</script>";
        String result = userController.greeting(maliciousName);

        // Verify that the response contains the malicious script (this is a vulnerability)
        assertTrue(result.contains(maliciousName));
    }
}
