package org.example.ex_21092024.testNGexample;

import groovy.transform.ToString;
import org.testng.annotations.Test;

public class TestNG006 {

    @Test
    public void serverstartedok(){
        System.out.println("I will run first");
    }

    @Test(dependsOnMethods = "serverstartedok")
    public void testmethod(){
        System.out.println("method");
    }
}
