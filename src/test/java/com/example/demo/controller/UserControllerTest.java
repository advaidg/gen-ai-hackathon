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
public class UserControllerTest {

    @Mock
    private DemoService demoService;

    @InjectMocks
    private UserController userController;

    @Test
    public void getAllUsers_shouldReturnListOfUsers() {
        // Arrange
        List<User> users = Arrays.asList(
                new User(1L, "John", "Doe"),
                new User(2L, "Jane", "Doe")
        );
        when(demoService.getAllUsers()).thenReturn(users);

        // Act
        List<User> result = userController.getAllUsers();

        // Assert
        assertEquals(users, result);
    }

    @Test
    public void getUserById_shouldReturnUserById() {
        // Arrange
        Long userId = 1L;
        User user = new User(userId, "John", "Doe");
        when(demoService.getUserById(userId)).thenReturn(user);

        // Act
        User result = userController.getUserById(userId);

        // Assert
        assertEquals(user, result);
    }

    @Test
    public void greeting_shouldReturnGreetingWithEscapedName() {
        // Arrange
        String name = "John<script>alert('XSS')</script>";
        String expectedGreeting = "Hello, John&lt;script&gt;alert('XSS')&lt;/script&gt;!";

        // Act
        String result = userController.greeting(name);

        // Assert
        assertEquals(expectedGreeting, result);
    }
}
