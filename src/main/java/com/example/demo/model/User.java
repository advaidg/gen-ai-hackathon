package com.example.demo.model;

import java.util.Optional;
import java.util.regex.Pattern;

public class User {
    
    private Long id;
    private String name; // Renamed to follow camelCase convention
    private int age; // Renamed to follow camelCase convention, make use of validation
    private String phoneNumber;

    // Password field should be handled securely (hashed, etc.), instead of storing plain text.
    private String passwordHash;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Validate name: should match regular expression pattern [a-z][a-zA-Z0-9]*
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Invalid name format");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // Validate age: use Optional to handle potential invalid values
        if (age < 0 || age > 150) { // Assuming realistic age constraints
            throw new IllegalArgumentException("Invalid age value");
        }
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        // Validate phone number for correctness (pattern can be enhanced as per requirements)
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String password) {
        // Hash the plain-text password before storing. For example, use BCrypt or similar.
        this.passwordHash = hashPassword(password);
    }

    // Utility method to validate name based on the pattern.
    private boolean isValidName(String name) {
        return Pattern.matches("^[a-z][a-zA-Z0-9]*$", name);
    }

    // Utility method to validate phone numbers (simplified version; can be modified based on use case)
    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\+?[0-9]+");
    }

    // Utility method to hash the password - demonstrates usage of hashing while setting the password.
    private String hashPassword(String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
        // Placeholder hashing logic - use a proper hash mechanism such as BCrypt or Argon2
        // You can replace it with real hashing logic later.
        return Integer.toHexString(password.hashCode());
    }
}
