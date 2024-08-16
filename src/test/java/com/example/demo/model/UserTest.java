package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void setId() {
        User user = new User();
        Long expectedId = 1L;
        user.setId(expectedId);
        assertEquals(expectedId, user.getId());
    }

    @Test
    void setName() {
        User user = new User();
        String expectedName = "John Doe";
        user.setName(expectedName);
        assertEquals(expectedName, user.getName());
    }

    @Test
    void setAddress() {
        User user = new User();
        String expectedAddress = "123 Main St";
        user.setAddress(expectedAddress);
        assertEquals(expectedAddress, user.getAddress());
    }

    @Test
    void setAge() {
        User user = new User();
        int expectedAge = 30;
        user.setAge(expectedAge);
        assertEquals(expectedAge, user.getAge());
    }

    @Test
    void setPhoneNumber() {
        User user = new User();
        String expectedPhoneNumber = "123-456-7890";
        user.setPhoneNumber(expectedPhoneNumber);
        assertEquals(expectedPhoneNumber, user.getPhoneNumber());
    }

    @Test
    void setPassword() {
        User user = new User();
        String expectedPassword = "password123";
        user.setPassword(expectedPassword);
        assertEquals(expectedPassword, user.getPassword());
    }
}
