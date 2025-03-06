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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private DemoService demoService;

    @InjectMocks
    private UserController userController;

    @Test
    void getAllUsers_shouldReturnListOfUsers() {
        List<User> users = Arrays.asList(new User(1L, "Test User"), new User(2L, "Another User"));
        when(demoService.getAllUsers()).thenReturn(users);

        List<User> result = userController.getAllUsers();

        assertEquals(users, result);
        verify(demoService, times(1)).getAllUsers();
    }

    @Test
    void getUserById_shouldReturnUser_whenUserExists() {
        User user = new User(1L, "Test User");
        when(demoService.getUserById(1L)).thenReturn(user);

        User result = userController.getUserById(1L);

        assertEquals(user, result);
        verify(demoService, times(1)).getUserById(1L);
    }


    @Test
    void getUserById_shouldReturnNull_whenUserDoesNotExist() {
        when(demoService.getUserById(1L)).thenReturn(null);

        User result = userController.getUserById(1L);

        assertNull(result);
        verify(demoService, times(1)).getUserById(1L);
    }

    @Test
    void greeting_shouldReturnGreetingMessage() {
        String name = "Test User";
        String expectedGreeting = "Hello, " + name + "!";
        String result = userController.greeting(name);
        assertEquals(expectedGreeting, result);

    }

    @Test
    void greeting_shouldHandleNullName() {
        String result = userController.greeting(null);
        assertEquals("Hello, null!", result); // Demonstrates vulnerability, ideally should handle this better.
    }

    @Test
    void greeting_shouldHandleEmptyString() {
        String result = userController.greeting("");
        assertEquals("Hello, !", result); // Demonstrates vulnerability, ideally should handle this better.
    }


    // Add more tests to cover edge cases and error handling as needed.  For example:
    // Test for exceptions thrown by the service layer.  Test for different input types.
    //  Consider adding tests for the security vulnerability using parameterized tests to input malicious strings.


}
