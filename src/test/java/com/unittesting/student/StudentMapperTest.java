package com.unittesting.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    void setUp() {
        System.out.println("run before each method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("run after each method");
    }

    @Test
    public void testMethod1(){
        System.out.println("testMethod 1");
    }

    @Test
    public void testMethod2(){
        System.out.println("testMethod 2");
    }
}