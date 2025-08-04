package com.example.demo;

import org.junit.jupiter.api.*;

public class MyTest {

    @BeforeEach
    public void beforeTest(){
        System.out.println("執行 @BeforeEach");
    }

    @AfterEach
    public void afterTest(){
        System.out.println("執行 @AfterEach");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("執行 @BeforeAll");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("執行 @AfterAll");
    }

    @Test
    public void test1(){
        System.out.println("執行test1");
    }

    @Test
    public void test2(){
        System.out.println("執行test2");
    }

}
