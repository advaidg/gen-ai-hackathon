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

import java.util.ArrayList;
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
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "Test User"));
        when(demoService.getAllUsers()).thenReturn(userList);

        List<User> result = userController.getAllUsers();
        assertEquals(userList, result);
        verify(demoService, times(1)).getAllUsers();
    }

    @Test
    void getAllUsers_shouldReturnEmptyList() {
        when(demoService.getAllUsers()).thenReturn(new ArrayList<>());
        List<User> result = userController.getAllUsers();
        assertTrue(result.isEmpty());
        verify(demoService, times(1)).getAllUsers();
    }


    @Test
    void getUserById_shouldReturnUser() {
        User user = new User(1L, "Test User");
        when(demoService.getUserById(1L)).thenReturn(user);

        User result = userController.getUserById(1L);
        assertEquals(user, result);
        verify(demoService, times(1)).getUserById(1L);
    }

    @Test
    void getUserById_shouldReturnNull() {
        when(demoService.getUserById(1L)).thenReturn(null);
        User result = userController.getUserById(1L);
        assertNull(result);
        verify(demoService, times(1)).getUserById(1L);
    }


    @Test
    void greeting_shouldReturnGreeting() {
        String name = "Test User";
        String expectedGreeting = "Hello, " + name + "!";
        String result = userController.greeting(name);
        assertEquals(expectedGreeting, result);
    }

    @Test
    void greeting_shouldHandleNullName() {
        String result = userController.greeting(null);
        assertEquals("Hello, null!", result); // Demonstrates the XSS vulnerability.  Should be improved in real application.
    }

    @Test
    void greeting_shouldHandleSpecialCharacters(){
        String name = "<script>alert('XSS')</script>";
        String result = userController.greeting(name);
        assertEquals("Hello, <script>alert('XSS')</script>!", result); // Demonstrates the XSS vulnerability. Should be improved in real application.

    }

}
