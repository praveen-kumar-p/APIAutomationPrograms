package org.example.ex_21092024.testNGexample;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG007 {

    @Parameters("browser")
    @Test
    void demo1(String value){
        System.out.println("Browser is " + value);
    }
}
