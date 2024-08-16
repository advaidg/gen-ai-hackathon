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
        List<User> users = Arrays.asList(new User(1L, "John Doe"), new User(2L, "Jane Doe"));
        when(demoService.getAllUsers()).thenReturn(users);

        List<User> result = userController.getAllUsers();

        assertEquals(users, result);
        verify(demoService, times(1)).getAllUsers();
    }

    @Test
    public void testGetUserById() {
        User user = new User(1L, "John Doe");
        when(demoService.getUserById(1L)).thenReturn(user);

        User result = userController.getUserById(1L);

        assertEquals(user, result);
        verify(demoService, times(1)).getUserById(1L);
    }

    @Test
    public void testGreeting() {
        String name = "Test User";
        String expectedGreeting = "Hello, " + name + "!";

        String result = userController.greeting(name);

        assertEquals(expectedGreeting, result);
    }

    @Test
    public void testGreetingWithXSSInput() {
        String name = "<script>alert('XSS Attack!')</script>";
        String expectedGreeting = "Hello, " + name + "!";

        String result = userController.greeting(name);

        assertEquals(expectedGreeting, result); // Expect the raw input to be returned
    }

}
