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
    void testGetAllUsers() {
        List<User> users = Arrays.asList(new User(1L, "Test User"), new User(2L, "Another User"));
        when(demoService.getAllUsers()).thenReturn(users);

        List<User> result = userController.getAllUsers();

        assertEquals(users, result);
        verify(demoService, times(1)).getAllUsers();
    }

    @Test
    void testGetUserById() {
        User user = new User(1L, "Test User");
        when(demoService.getUserById(1L)).thenReturn(user);

        User result = userController.getUserById(1L);

        assertEquals(user, result);
        verify(demoService, times(1)).getUserById(1L);
    }


    @Test
    void testGetUserByIdNotFound() {
        when(demoService.getUserById(3L)).thenReturn(null);

        User result = userController.getUserById(3L);

        assertNull(result);
        verify(demoService, times(1)).getUserById(3L);

    }

    @Test
    void testGreeting() {
        String name = "Test User";
        String expectedGreeting = "Hello, " + name + "!";
        String result = userController.greeting(name);
        assertEquals(expectedGreeting, result);
    }

    @Test
    void testGreetingWithXSSInput() {
        //This test demonstrates the vulnerability,  not a fix.  A real application would need input sanitization.
        String name = "<script>alert('XSS')</script>";
        String result = userController.greeting(name);
        assertEquals("Hello, <script>alert('XSS')</script>!", result); // This shows the vulnerability
    }


}
