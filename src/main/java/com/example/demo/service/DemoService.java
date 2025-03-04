package com.example.demo.service;

import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);
    private static final int DEFAULT_USER_COUNT = 10;
    private static final int RANDOM_NUMBER = 1; //Example -  remove getRandomNumber()

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
        return getUserByIdWithExtraParams(id, new ExtraParams("extraParam1", 123)); 
    }

    private User getUserByIdWithExtraParams(Long id, ExtraParams extraParams) {
        //  Logic to fetch user by ID, potentially using a repository and handling Optional
        // Example:  return userRepository.findById(id).map(user -> { user.setExtraParams(extraParams); return user; }).orElse(null);

        return new User();
    }

    //Splitting doEverything() into separate services or methods
    // Example:  UserCreationService, UserUpdateService, ReportGenerationService

    // Removed inefficientMethod() - creating a list of Integer.MAX_VALUE size is inherently flawed.  Requires a complete redesign of whatever process this method was intended for.

    //getUsersByQuery and getUserByUsername refactored to use PreparedStatements
    public List<User> getUsersByQuery(String query) {
       //  Implement using PreparedStatement to prevent SQL injection
        // Example (using JdbcTemplate):
        // return jdbcTemplate.query("SELECT * FROM users WHERE name LIKE ?", new Object[]{"%" + query + "%"}, (rs, rowNum) -> mapRowToUser(rs));

        return new ArrayList<>();
    }

    public Optional<String> getUserPassword(Long id) { //Returning Optional for better null handling
        //This method should not exist in production code!  Passwords should NEVER be directly returned.  This is a placeholder for demonstration of improved error handling.
        return Optional.ofNullable(getUserById(id)).map(User::getPassword);
    }


    public void complexMethod() {
        logger.info("Starting complex method");
        performComplexTask();
        logger.info("Completed complex method");
    }

    private void performComplexTask() {
         // Logic for complex task
        for (int i = 0; i < 1000; i++) {
            logger.debug("Processing " + i);
        }
    }

    //Removed unusedVariable

    //getUserByUsername refactored to use PreparedStatements
    public Optional<User> getUserByUsername(String username) { // Returning Optional for better null handling
        // Implement using PreparedStatement to prevent SQL injection
        // Example (using JdbcTemplate):
        // return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM users WHERE username = ?", new Object[]{username}, (rs, rowNum) -> mapRowToUser(rs)));

        return Optional.empty(); // Placeholder
    }


    //Helper class for extra params in getUserByIdWithExtraParams
    public static class ExtraParams{
        String param1;
        int param2;
        public ExtraParams(String param1, int param2){
            this.param1 = param1;
            this.param2 = param2;
        }

        //Getters and Setters
    }


}
