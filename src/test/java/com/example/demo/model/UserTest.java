package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testSetAndGetId() {
        User user = new User();
        Long id = 1L;
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    void testSetAndGetAge() {
        User user = new User();
        int age = 30;
        user.setAge(age);
        assertEquals(age, user.getAge());
    }

    @Test
    void testSetAndGetName() {
        User user = new User();
        String name = "John Doe";
        user.setName(name);
        assertEquals(name, user.getName());
    }

    @Test
    void testSetAndGetPhoneNumber() {
        User user = new User();
        String phoneNumber = "123-456-7890";
        user.setPhoneNumber(phoneNumber);
        assertEquals(phoneNumber, user.getPhoneNumber());
    }

    @Test
    void testSetAndGetPassword() {
        User user = new User();
        String password = "password123";
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }
}
