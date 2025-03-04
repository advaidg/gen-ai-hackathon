package com.example.demo.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class User {
    private Integer id; // Changed to Integer
    private String name;
    private Integer age; // Changed to Integer and added context (if needed, add a comment specifying the age range)
    private String contactDetails; //Combined address and phoneNumber


    private byte[] passwordHash; // Store password hash instead of plain text

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }


    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public void setPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // Use strong hashing algorithm
            this.passwordHash = md.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 hashing algorithm not found", e);
        }
    }


    //For password verification
    public boolean verifyPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] passwordHash = md.digest(password.getBytes());
            return Arrays.equals(this.passwordHash, passwordHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 hashing algorithm not found", e);
        }
    }

}
