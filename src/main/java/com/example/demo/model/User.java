package com.example.demo.model;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class User {
    private Long id;
    private String name;
    private int userAge; // Renamed and clarified
    private String phoneNumber;

    private String encryptedPassword; // Store password securely

    public User() {} // Added a no-args constructor

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Secure password handling
    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setPassword(String password) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        //  In a real-world scenario, this password would be fetched securely from a secrets manager.  
        //  Hardcoding is done here ONLY for demonstration purposes.  NEVER hardcode passwords in production.
        encryptor.setPassword("your_strong_password");  
        this.encryptedPassword = encryptor.encrypt(password);
    }


    public String getPassword(){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("your_strong_password");
        return encryptor.decrypt(this.encryptedPassword);
    }
}
