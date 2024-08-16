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
        int age = 25;
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


package com.example.demo.model;

public class User {
    private Long id;
    private String name;
    private int age;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
