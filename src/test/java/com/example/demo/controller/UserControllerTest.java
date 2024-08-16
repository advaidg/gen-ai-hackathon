package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public void testGetAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "John Doe", "john.doe@example.com"));
        users.add(new User(2L, "Jane Doe", "jane.doe@example.com"));

        when(demoService.getAllUsers()).thenReturn(users);

        List<User> result = userController.getAllUsers();

        assertEquals(users, result);
        verify(demoService, times(1)).getAllUsers();
    }

    @Test
    public void testGetUserById() {
        Long userId = 1L;
        User user = new User(userId, "John Doe", "john.doe@example.com");

        when(demoService.getUserById(userId)).thenReturn(user);

        User result = userController.getUserById(userId);

        assertEquals(user, result);
        verify(demoService, times(1)).getUserById(userId);
    }

    @Test
    public void testGreeting() {
        String name = "Test User";
        String expectedGreeting = "Hello, " + name + "!";

        String result = userController.greeting(name);

        assertEquals(expectedGreeting, result);
    }

}
