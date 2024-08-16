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

import java.util.ArrayList;
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
    public void getAllUsers_shouldReturnListOfUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "John Doe", "john.doe@example.com"));
        users.add(new User(2L, "Jane Doe", "jane.doe@example.com"));

        when(demoService.getAllUsers()).thenReturn(users);

        List<User> result = userController.getAllUsers();

        assertEquals(users, result);
    }

    @Test
    public void getUserById_shouldReturnUserWithMatchingId() {
        User user = new User(1L, "John Doe", "john.doe@example.com");

        when(demoService.getUserById(1L)).thenReturn(user);

        User result = userController.getUserById(1L);

        assertEquals(user, result);
    }

    @Test
    public void greeting_shouldReturnGreetingWithGivenName() {
        String name = "Test User";
        String expectedGreeting = "Hello, " + name + "!";

        String result = userController.greeting(name);

        assertEquals(expectedGreeting, result);
    }

    // Test for potential XSS vulnerability
    @Test
    public void greeting_shouldEscapeInput() {
        // This test is incomplete and will need to be updated with actual sanitization logic
        // For demonstration purposes, it will only check for basic script injection
        String name = "<script>alert('XSS');</script>";
        String expectedGreeting = "Hello, " + name + "!";

        String result = userController.greeting(name);

        assertNotEquals(expectedGreeting, result); // Ensure input is escaped
    }
}
