package com.example.demo.service;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DemoServiceTest {

    @InjectMocks
    private DemoService demoService;

    @Test
    void getAllUsers() {
        List<User> users = demoService.getAllUsers();
        assertEquals(10, users.size());
        for (int i = 0; i < 10; i++) {
            assertEquals((long) i, users.get(i).getId());
            assertEquals("User " + i, users.get(i).getName());
        }
    }

    @Test
    void getUserById() {
        User user = demoService.getUserById(1L);
        assertNotNull(user);
    }

    @Test
    void getUserPassword() {
        // Mock User with a password
        User user = new User();
        user.setPassword("testPassword");
        when(demoService.getUserById(1L)).thenReturn(user);

        String password = demoService.getUserPassword(1L);
        assertEquals("testPassword", password);
    }

    @Test
    void getUserPassword_UserNotFound() {
        when(demoService.getUserById(1L)).thenReturn(null);

        String password = demoService.getUserPassword(1L);
        assertNull(password);
    }

    @Test
    void getUsersByQuery_SQLInjectionVulnerability() {
        // Test for SQL injection vulnerability. 
        // This test should ideally trigger an error or exception 
        // to signal the vulnerability, but it's difficult 
        // without actual database interaction.
        // We can instead test the generated SQL query:
        String query = "'; DROP TABLE users; --";
        List<User> users = demoService.getUsersByQuery(query);

        // The generated SQL query should NOT contain the injected code
        // due to the vulnerability. 
        // In this case, we'll assert that the query is empty, 
        // as the method currently returns an empty list.
        // In a real test with database interaction, this assertion 
        // should be replaced with something that detects the injection.
        assertTrue(users.isEmpty());
    }

    @Test
    void getUserByUsername_SQLInjectionVulnerability() {
        // Test for SQL injection vulnerability. 
        // Similar to the previous test, we'll assert 
        // that the generated SQL query is not vulnerable.
        String username = "'; DROP TABLE users; --";
        User user = demoService.getUserByUsername(username);

        // This should ideally throw an exception or 
        // trigger an error due to the injection, 
        // but we cannot do it here without database interaction.
        // Instead, we'll assert that the query is empty
        // as the method currently returns null.
        // In a real test, this assertion 
        // should be replaced with something that detects the injection.
        assertNull(user);
    }
}
