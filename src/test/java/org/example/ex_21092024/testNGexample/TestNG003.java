package org.example.ex_21092024.testNGexample;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG003 {

    @BeforeTest
    public void getToken(){
        System.out.println("1");
    }
    @BeforeTest
    public void getBookingID(){
        System.out.println("2");
    }
    @BeforeTest
    public void getBookingID1(){
        System.out.println("3");
    }
    @Test
    public void test_PUT(){
        // token and BookingID
        System.out.println("4");
    }
}
