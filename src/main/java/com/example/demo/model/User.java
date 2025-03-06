package com.example.demo.model;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class User {
    private Long id;
    private String name;
    private int age; 
    private String phoneNumber;

    private String encryptedPassword;


    public User(String name, int age, String phoneNumber, String password) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    //This method should ideally be in a separate security utility class
    private String encryptPassword(String password) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        //In a real application, this password should be managed securely (e.g., environment variable, secrets manager)
        encryptor.setPassword("your_strong_password"); //REPLACE WITH SECURELY MANAGED PASSWORD
        return encryptor.encrypt(password);
    }

    //This method should ideally be in a separate security utility class and handle exceptions appropriately.
    public String decryptPassword(String encryptedPassword) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("your_strong_password"); //REPLACE WITH SECURELY MANAGED PASSWORD
        return encryptor.decrypt(encryptedPassword);
    }

}
