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
    void testGetAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Test User"));
        when(demoService.getAllUsers()).thenReturn(users);

        List<User> result = userController.getAllUsers();
        assertEquals(1, result.size());
        assertEquals("Test User", result.get(0).getName());
        verify(demoService, times(1)).getAllUsers();
    }

    @Test
    void testGetUserById() {
        User user = new User(1L, "Test User");
        when(demoService.getUserById(1L)).thenReturn(user);

        User result = userController.getUserById(1L);
        assertEquals(1L, result.getId());
        assertEquals("Test User", result.getName());
        verify(demoService, times(1)).getUserById(1L);
    }


    @Test
    void testGetUserByIdNotFound() {
        when(demoService.getUserById(2L)).thenReturn(null);

        User result = userController.getUserById(2L);
        assertNull(result);
        verify(demoService, times(1)).getUserById(2L);
    }

    @Test
    void testGreeting() {
        String name = "Test User";
        String expectedGreeting = "Hello, " + name + "!";
        String result = userController.greeting(name);
        assertEquals(expectedGreeting, result);
    }

    @Test
    void testGreetingWithXSSInput(){
        String name = "<script>alert('XSS')</script>";
        String result = userController.greeting(name);
        //This test only verifies the basic functionality.  A robust test would involve a security scanner or further analysis of the response.  
        assertTrue(result.contains(name)); //Asserting the vulnerability is still present.  This is NOT a secure solution!
    }


}
