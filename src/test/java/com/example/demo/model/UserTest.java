package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testGettersAndSetters() {
        User user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setAddress("123 Main Street");
        user.setAge(30);
        user.setPhoneNumber("555-123-4567");
        user.setPassword("password123");

        assertEquals(1L, user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("123 Main Street", user.getAddress());
        assertEquals(30, user.getAge());
        assertEquals("555-123-4567", user.getPhoneNumber());
        assertEquals("password123", user.getPassword());
    }

    // Test for address field - not recommended, as it's unnecessary
    @Test
    void testAddress() {
        User user = new User();
        user.setAddress("123 Main Street");
        assertEquals("123 Main Street", user.getAddress());
    }

    // Test for Age field - not recommended, as it's a magic number
    @Test
    void testAge() {
        User user = new User();
        user.setAge(30);
        assertEquals(30, user.getAge());
    }
}

