package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private DemoService demoService;

    @Test
    void getAllUsers() {
        List<User> users = Arrays.asList(
                new User(1L, "John Doe"),
                new User(2L, "Jane Doe")
        );
        when(demoService.getAllUsers()).thenReturn(users);

        List<User> result = userController.getAllUsers();

        assertEquals(users, result);
    }

    @Test
    void getUserById() {
        User user = new User(1L, "John Doe");
        when(demoService.getUserById(1L)).thenReturn(user);

        User result = userController.getUserById(1L);

        assertEquals(user, result);
    }

    @Test
    void greeting() {
        String name = "Test User";
        String expectedGreeting = "Hello, " + name + "!";
        String result = userController.greeting(name);

        assertEquals(expectedGreeting, result);
    }

    // Test for XSS vulnerability in greeting method
    @Test
    void greeting_XSS() {
        String name = "<script>alert('XSS Attack')</script>";
        String result = userController.greeting(name);

        // Assert that the input is not directly reflected in the output
        // This test highlights the vulnerability, but doesn't actually exploit it
        assertNotEquals("Hello, " + name + "!", result);
    }
}
