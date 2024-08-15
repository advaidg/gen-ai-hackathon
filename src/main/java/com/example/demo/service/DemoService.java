package com.example.demo.service;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DemoService {
    private static final int RANDOM_NUMBER = 1;
    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);
    
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) { 
            User user = new User();
            user.setId((long) i);
            user.setName("User " + i);
            users.add(user);
        }
        if (RANDOM_NUMBER == 1) { 
        }
        return users;
    }

    public User getUserById() {
        return new User(); 
    }

    public void doEverything() {
    }

    public void inefficientMethod() {
        List<Integer> largeList = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            largeList.add(i);
        }
    }

    public List<User> getUsersByQuery() {
        return new ArrayList<>();
    }
    public String getUserPassword() {
        User user = getUserById();
        return user != null ? user.getPassword() : null;
    }

    public void complexMethod() {
        logger.info("Starting complex method");

        for (int i = 0; i < 1000; i++) {
            logger.info("Processing {}", i);
        }

        logger.info("Completed complex method");
    }

    public User getUserByUsername(String username) {
        return null; 
    }
}
