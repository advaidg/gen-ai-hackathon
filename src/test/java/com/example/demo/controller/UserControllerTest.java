package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public void getAllUsers() {
        List<User> users = Arrays.asList(new User(1L, "John Doe"), new User(2L, "Jane Doe"));
        when(demoService.getAllUsers()).thenReturn(users);

        List<User> result = userController.getAllUsers();

        assertEquals(users, result);
        verify(demoService, times(1)).getAllUsers();
    }

    @Test
    public void getUserById() {
        User user = new User(1L, "John Doe");
        when(demoService.getUserById(1L)).thenReturn(user);

        User result = userController.getUserById(1L);

        assertEquals(user, result);
        verify(demoService, times(1)).getUserById(1L);
    }

    @Test
    public void greeting() {
        String name = "John Doe";
        String expectedGreeting = "Hello, John Doe!";

        String result = userController.greeting(name);

        assertEquals(expectedGreeting, result);
    }

    @Test
    public void greeting_with_special_characters() {
        String name = "<script>alert('XSS')</script>";
        String expectedGreeting = "Hello, <script>alert('XSS')</script>!";

        String result = userController.greeting(name);

        assertEquals(expectedGreeting, result);
    }

    // Additional Test Case for security vulnerability (XSS)
    @Test
    public void greeting_with_xss_injection() {
        // Test case to demonstrate potential XSS vulnerability
        String name = "<script>alert('XSS')</script>";
        String result = userController.greeting(name);

        // Assert that the response includes the malicious script
        assertTrue(result.contains("<script>alert('XSS')</script>"));
    }
}
