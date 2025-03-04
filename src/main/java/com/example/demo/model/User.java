package com.example.demo.model;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class User {
    private Long id;
    private String name;
    private Long age; 
    private String password;

    private static final String AGE_DESCRIPTION = "User's age in years"; //Added description for better understanding


    public User() {} //Added a no-args constructor

    public User(String name, Long age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }


    public String getPassword() {
        // Decrypt the password before returning
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("your_strong_password"); // Replace with a secure mechanism for storing the encryption key

        try{
            return encryptor.decrypt(this.password);
        } catch (Exception e){
            //Handle exceptions appropriately, like logging the error and returning a default value or throwing a custom exception
            return null;
        }
    }

    public void setPassword(String password) {
        // Encrypt the password before storing
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("your_strong_password"); // Replace with a secure mechanism for storing the encryption key
        this.password = encryptor.encrypt(password);
    }
}
