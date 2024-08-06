package com.example.demo.service;

import com.example.demo.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();

    // Code Smell: Static list makes data shared across all instances, potential data inconsistency
    private static List<User> staticUsers = new ArrayList<>();

    public List<User> getAllUsers() {
        // Code Smell: Directly returning the list allows modification from outside
        return users;
    }

    public User getUserById(Long id) {
        // Code Smell: Null check missing for id parameter, potential NullPointerException
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public void addUser(User user) {
        // Code Smell: Lack of validation on user object
        users.add(user);
    }

    public void deleteUser(Long id) {
        // Security Hotspot: Deletion without proper authentication/authorization check
        users.removeIf(user -> user.getId().equals(id));
    }

    // Code Smell: Duplicated code
    public void duplicateMethod() {
        System.out.println("This is duplicate code");
        System.out.println("This is duplicate code");
    }

    // Security Hotspot: Hardcoded sensitive data
    public String getSecretKey() {
        return "hardcoded_secret_key";
    }

    // Code Smell: Method does nothing useful, potential dead code
    public void doNothing() {
        // No operation
    }

    // Security Hotspot: Using system property for user directory without validation
    public String getUserDirectory() {
        return System.getProperty("user.dir");
    }

    // Code Smell: Inconsistent naming convention
    public void inconsistentnamingmethod() {
        System.out.println("Inconsistent naming");
    }

    // Security Hotspot: Sensitive data exposure
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

    // Code Smell: Unused variable
    private String unusedVariable = "I am not used";

    // Security Hotspot: SQL Injection vulnerability
    public User getUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        // Execute query and return result (pseudo code)
        // return database.executeQuery(query);
        return null; // Placeholder
    }
}

