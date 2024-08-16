package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTest {

    @Test
    void contextLoads() {
        // This test simply verifies that the application context loads successfully.
        assertNotNull(DemoApplication.class);
    }
}
