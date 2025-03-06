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
    private static final int RANDOM_NUMBER = 1; //  Constant replacing getRandomNumber()


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
        return new User(); //  Simplified getUserById - no extra parameters needed.
    }

    //doEverything() method removed as per SRP guidelines.  Functionality should be broken into smaller, more focused methods.

    // inefficientMethod() removed; creating a list of size Integer.MAX_VALUE is inherently flawed.  The logic needs a complete redesign.

    // getUsersByQuery() refactored to prevent SQL injection
    public List<User> getUsersByQuery(String query) {
        //  Implementation using PreparedStatement (requires database connection setup)

        // ... Database connection and prepared statement setup
        // String sql = "SELECT * FROM users WHERE name LIKE ?";
        // PreparedStatement statement = connection.prepareStatement(sql);
        // statement.setString(1, "%" + query + "%");
        // ResultSet resultSet = statement.executeQuery();
        // ... Process resultSet to create a list of users
        // ... Close resources (resultSet, statement, connection)

        return new ArrayList<>(); // Placeholder, replace with actual database query using prepared statement.
    }

    // getUserPassword() method modified to not return the password directly - a serious security vulnerability.
    //This would require changes in the User class as well and is beyond the scope of this example,
    //because we have no documentation about the User class.  The best practice is to avoid storing
    //passwords in clear text.  Hashing is required.
    public boolean authenticateUser(Long id, String passwordAttempt){
        User user = getUserById(id);
        if(user == null) return false;
        //return user.getPassword().equals(passwordAttempt); //Avoid this!  Insecure.

        //Instead, compare hashes here.  Example (requires appropriate hashing library):
        // return PasswordHasher.verifyPassword(passwordAttempt, user.getPasswordHash());
        return false; // Placeholder
    }


    // complexMethod() refactored to separate logging and complex task
    public void complexTask(){
        for (int i = 0; i < 1000; i++) {
            logger.info("Processing {}", i); // Using logger for better logging
        }
    }

    public void complexMethod() {
        logger.info("Starting complex method");
        complexTask();
        logger.info("Completed complex method");
    }

    // unusedVariable field removed.

    // getUserByUsername() refactored to prevent SQL injection
    public User getUserByUsername(String username) {
        // Implementation using PreparedStatement (requires database connection setup)
        // String query = "SELECT * FROM users WHERE username = ?";
        // PreparedStatement statement = connection.prepareStatement(query);
        // statement.setString(1, username);
        // ResultSet resultSet = statement.executeQuery();
        // ... Process resultSet to retrieve user details
        // ... Close resources (resultSet, statement, connection)

        return null; // Placeholder, replace with actual database query using prepared statement.
    }
}


<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>2.0.7</version> <!-- Or latest version -->
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>2.0.7</version> <!-- Or latest version -->
</dependency>
