package org.example.ex_21092024.testNGexample.Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class Test009_Hardassertion {

//    @Test
//    public void hardassert(){
//        Assert.assertTrue(false);
//        System.out.println("This line will not be executed");
//    }

    @Test
    public void softassert(){
        SoftAssert softassert = new SoftAssert();
        softassert.assertTrue(false);
        System.out.println("This line will be executed");
        softassert.assertAll();
    }
}
