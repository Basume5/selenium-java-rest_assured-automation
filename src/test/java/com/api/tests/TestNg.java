package com.api.tests;

import org.testng.annotations.Test;

public class TestNg {

    @Test
    void setup(){
        System.out.println("Setup");
    }

    @Test
    void testSteps(){
        System.out.println("TestSteps");
    }

    @Test
    void teardown(){
        System.out.println("Teardown");
    }
}
