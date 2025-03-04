package com.example.demo.model;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @NotNull
    private Long id;

    @NotBlank
    @Size(min = 2, max = 255) //Example validation, adjust as needed
    private String name;

    @NotNull
    private Integer age; // Using Integer to allow for null values

    @NotBlank
    @Size(min = 10, max = 20) //Example phone number validation, adjust as needed.
    private String phoneNumber;


    private String encryptedPassword; // Store encrypted password


    public User() {} //Needed for JPA/Hibernate

    public User(Long id, String name, Integer age, String phoneNumber, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.encryptedPassword = encryptPassword(password);
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    //This is only used to set the password and encrypt it during creation.  
    //Never expose a method to set the password directly in a production environment.
    private void setPassword(String password) {
        this.encryptedPassword = encryptPassword(password);
    }

    //Helper Method for password encryption
    private String encryptPassword(String password) {
        if (password == null) return null;
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        //This password MUST be securely managed, not hardcoded!  Use environment variables or secrets management.
        encryptor.setPassword("your_strong_password"); //REPLACE WITH SECURE PASSWORD MANAGEMENT
        return encryptor.encrypt(password);
    }


    //Helper Method for password decryption (for testing purposes only, NEVER in production)
    public String decryptPassword(String encryptedPassword){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        //This password MUST be securely managed, not hardcoded! Use environment variables or secrets management.
        encryptor.setPassword("your_strong_password"); //REPLACE WITH SECURE PASSWORD MANAGEMENT
        return encryptor.decrypt(encryptedPassword);
    }
}
