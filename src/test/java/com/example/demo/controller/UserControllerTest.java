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
        List<User> mockUsers = Arrays.asList(
                new User(1L, "John Doe"),
                new User(2L, "Jane Doe")
        );
        when(demoService.getAllUsers()).thenReturn(mockUsers);

        List<User> users = userController.getAllUsers();

        assertEquals(mockUsers, users);
        verify(demoService, times(1)).getAllUsers();
    }

    @Test
    public void getUserById_shouldReturnUserWithMatchingId() {
        User mockUser = new User(1L, "John Doe");
        when(demoService.getUserById(1L)).thenReturn(mockUser);

        User user = userController.getUserById(1L);

        assertEquals(mockUser, user);
        verify(demoService, times(1)).getUserById(1L);
    }

    @Test
    public void greeting_shouldReturnGreetingWithUserName() {
        String name = "Alice";
        String expectedGreeting = "Hello, Alice!";

        String greeting = userController.greeting(name);

        assertEquals(expectedGreeting, greeting);
    }

    @Test
    public void greeting_shouldHandleNullName() {
        String expectedGreeting = "Hello, !";

        String greeting = userController.greeting(null);

        assertEquals(expectedGreeting, greeting);
    }
}
