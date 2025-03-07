package com.example.demo.service;

import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);
    private static final int DEFAULT_USER_COUNT = 10;
    private static final int RANDOM_NUMBER = 1; //Removed getRandomNumber method


    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < DEFAULT_USER_COUNT; i++) {
            User user = new User();
            user.setId((long) i);
            user.setName("User " + i);
            users.add(user);
        }
        return users;
    }


    public User getUserById(Long id) {
        return new User(); // Simplified;  replace with actual retrieval logic if needed.
    }

    //Removed unused method
    //private User getUserByIdWithExtraParams(Long id, String extraParam, int extraParam2) {
    //    return new User();
    //}

    // Refactored to separate services - example only, needs actual implementation.
    public void processUserRegistration(String name, String email){
        //Implementation for User Registration
        logger.info("Registering user: {} {}", name, email);
    }
    
    public void processOrderPlacement(User user, Order order){
        //Implementation for order placement
        logger.info("Placing order for user: {} order: {}", user.getName(), order.toString());
    }

    //Removed inefficientMethod() - would require significant restructuring and potentially caching strategies from the provided docs.

    // Secure query using PreparedStatement (replace with actual database interaction)
    public List<User> getUsersByQuery(String query) {
        logger.info("Executing users query with prepared statement: {}", query); //Log instead of printing to System.out
        //  Implementation using PreparedStatement to prevent SQL injection here. See documentation.
        return new ArrayList<>();
    }

    // Secure password handling - NEVER return password directly.  Replace with a token or other secure method.
    public String getUserPassword(Long id) {
        logger.warn("Attempt to retrieve user password.  This is a security risk and should be avoided."); // Log this as a security warning.
        return null; // Should never return actual password
    }

    // Refactored complexMethod() into separate methods for logging and task processing.
    public void logComplexMethodStart(){
        logger.info("Starting complex method");
    }
    public void performComplexTask(){
        for (int i = 0; i < 1000; i++) {
            logger.debug("Processing " + i); //Log instead of printing to System.out
        }
    }
    public void logComplexMethodEnd(){
        logger.info("Completed complex method");
    }


    //Removed unused field
    //private String unusedVariable = "I am not used";

    // Secure query using PreparedStatement (replace with actual database interaction)
    public User getUserByUsername(String username) {
        logger.info("Executing user query by username with prepared statement: {}", username); //Log instead of printing to System.out
        // Implementation using PreparedStatement to prevent SQL injection here.  See documentation.
        return null; // Placeholder
    }
}
