package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private DemoService demoService;

    @InjectMocks
    private UserController userController;

    @Test
    void getAllUsers() {
        // Arrange
        List<User> users = Arrays.asList(
                new User(1L, "John Doe", "john.doe@example.com"),
                new User(2L, "Jane Doe", "jane.doe@example.com")
        );
        Mockito.when(demoService.getAllUsers()).thenReturn(users);

        // Act
        List<User> result = userController.getAllUsers();

        // Assert
        assertEquals(users, result);
    }

    @Test
    void getUserById() {
        // Arrange
        Long userId = 1L;
        User user = new User(userId, "John Doe", "john.doe@example.com");
        Mockito.when(demoService.getUserById(userId)).thenReturn(user);

        // Act
        User result = userController.getUserById(userId);

        // Assert
        assertEquals(user, result);
    }

    @Test
    void greeting() {
        // Arrange
        String name = "John Doe";
        String expectedGreeting = "Hello, " + name + "!";
        Mockito.when(demoService.getUserById(1L)).thenReturn(new User(1L, name, "john.doe@example.com"));

        // Act
        String result = userController.greeting(name);

        // Assert
        assertEquals(expectedGreeting, result);
    }
}
