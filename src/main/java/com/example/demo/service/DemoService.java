package com.example.demo.service;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {
    private static final int RANDOM_NUMBER = 1;
    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);
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
        if (getRandomNumber() == 1) { // Magic number
            // Unnecessary logic
        } else {
            // Default case
        }
        return users;
    }

    private int getRandomNumber() {
        // Random number generation logic
        return RANDOM_NUMBER;
    }

    public User getUserById(Long id) {
        // Long parameter list
        return getUserByIdWithExtraParams(); 
    }

    private User getUserByIdWithExtraParams() {
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
        logger.info("Starting complex method");

        // Perform a complex task
        for (int i = 0; i < 1000; i++) {
            logger.info("Processing " + i);
        }

        // Log completion
        logger.info("Completed complex method");
    }

    // Code Smell: Unused variable

    // Security Hotspot: SQL Injection vulnerability
    public User getUserByUsername(String username) {
        // Execute query and return result (pseudo code)
        // return database.executeQuery(query);
        return null; // Placeholder
    }
}
