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
        List<User> users = Arrays.asList(new User(1L, "John Doe"), new User(2L, "Jane Doe"));
        when(demoService.getAllUsers()).thenReturn(users);

        List<User> result = userController.getAllUsers();

        assertEquals(users, result);
        verify(demoService, times(1)).getAllUsers();
    }

    @Test
    void getUserById() {
        User user = new User(1L, "John Doe");
        when(demoService.getUserById(1L)).thenReturn(user);

        User result = userController.getUserById(1L);

        assertEquals(user, result);
        verify(demoService, times(1)).getUserById(1L);
    }

    @Test
    void greeting() {
        String name = "John Doe";
        String expectedGreeting = "Hello, " + name + "!";

        String result = userController.greeting(name);

        assertEquals(expectedGreeting, result);
    }

    // Test for potential XSS vulnerability
    @Test
    void greeting_XSS() {
        String maliciousInput = "<script>alert('XSS');</script>";
        String expectedGreeting = "Hello, " + maliciousInput + "!";

        String result = userController.greeting(maliciousInput);

        assertEquals(expectedGreeting, result);
        // Consider adding further assertions or logic to check for XSS prevention mechanisms
        // if implemented in the application
    }

}
