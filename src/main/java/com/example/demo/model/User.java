package com.example.demo.model;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class User {
    private Long id;
    private String name;
    private int userAge; //  More descriptive name
    private String contactInfo; // Combined contact information

    private String encryptedPassword; // Secure password storage


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
        this.name = name;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getPassword() {
        // Decrypt password when needed.  This method should ideally be called only in trusted contexts.
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("your_strong_password"); // Replace with a securely managed password
        return encryptor.decrypt(encryptedPassword);
    }

    public void setPassword(String password) {
        // Encrypt password before storing.  This is crucial for security.
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("your_strong_password"); // Replace with a securely managed password
        this.encryptedPassword = encryptor.encrypt(password);
    }
}
