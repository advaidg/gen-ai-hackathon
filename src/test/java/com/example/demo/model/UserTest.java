package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void setId() {
        User user = new User();
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    void setName() {
        User user = new User();
        user.setName("John Doe");
        assertEquals("John Doe", user.getName());
    }

    @Test
    void setAddress() {
        User user = new User();
        user.setAddress("123 Main Street");
        assertEquals("123 Main Street", user.getAddress());
    }

    @Test
    void setAge() {
        User user = new User();
        user.setAge(30);
        assertEquals(30, user.getAge());
    }

    @Test
    void setPhoneNumber() {
        User user = new User();
        user.setPhoneNumber("123-456-7890");
        assertEquals("123-456-7890", user.getPhoneNumber());
    }

    @Test
    void setPassword() {
        User user = new User();
        user.setPassword("password123");
        assertEquals("password123", user.getPassword());
    }
}
