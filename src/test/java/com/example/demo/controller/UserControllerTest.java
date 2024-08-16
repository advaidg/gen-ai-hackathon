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
    public void getAllUsers() {
        // Mock data
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "John Doe"));
        users.add(new User(2L, "Jane Doe"));

        // Mock service behavior
        when(demoService.getAllUsers()).thenReturn(users);

        // Call the controller method
        List<User> result = userController.getAllUsers();

        // Assertions
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(users, result);
    }

    @Test
    public void getUserById() {
        // Mock data
        User user = new User(1L, "John Doe");

        // Mock service behavior
        when(demoService.getUserById(1L)).thenReturn(user);

        // Call the controller method
        User result = userController.getUserById(1L);

        // Assertions
        assertNotNull(result);
        assertEquals(user, result);
    }

    @Test
    public void greeting() {
        // Mock data
        String name = "Alice";

        // Call the controller method
        String result = userController.greeting(name);

        // Assertions
        assertNotNull(result);
        assertEquals("Hello, Alice!", result);
    }
}
