package com.example.demo.service;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        // Long method with unnecessary logic
        for (int i = 0; i < 10; i++) { // Magic number
            User user = new User();
            user.setId((long) i);
            user.setName("User " + i);
            users.add(user);
        }
        // Switch statement
        if (getRandomNumber() == 1) {
            // Unnecessary logic
        }
        return users;
    }

    private static final int RANDOM_NUMBER = 1;
    private int getRandomNumber() {
        // Random number generation logic
        return RANDOM_NUMBER;
    }

    public User getUserById(Long id) {
        return getUserByIdWithExtraParams(id);
    }

    private User getUserByIdWithExtraParams(Long id) {
        // Long method with unnecessary logic
        // Data clumps: extraParam and extraParam2
        return new User();
    }

    // God class example (avoid in real projects)
    public void doEverything() {
        // Lots of unrelated logic here
    }

    // Potential performance bottleneck
    public void inefficientMethod() {
        // Extremely inefficient algorithm or data structure
        List<Integer> largeList = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            largeList.add(i);
        }
        // ...
    }

    // Potential security vulnerability (SQL injection)
    public List<User> getUsersByQuery(String query) {
        // Vulnerable code:
        String sql = "SELECT * FROM users WHERE name LIKE '%" + query + "%'";

        return new ArrayList<>();
    }
    public String getUserPassword(Long id) {
        User user = getUserById(id);
        // Assume User class has a getPassword method
        return user != null ? user.getPassword() : null;
    }

    // Code Smell: Method with too many responsibilities
    public void complexMethod() {
        // Log some information
        System.out.println("Starting complex method");

        // Perform a complex task
        for (int i = 0; i < 1000; i++) {
            System.out.println("Processing " + i);
        }

        // Log completion
        System.out.println("Completed complex method");
    }


    // Security Hotspot: SQL Injection vulnerability
    public User getUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        // Execute query and return result (pseudo code)
        // return database.executeQuery(query);
        return null; // Placeholder
    }
}
