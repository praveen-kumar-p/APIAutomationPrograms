package org.example.ex_21092024.testNGexample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG005 {

    @Test(groups = {"sanity", "qa", "preprod"})
    public void sanityrun(){
        System.out.println("sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"qa", "preprod", "reg"})
    public void Regrun(){
        System.out.println("Reg Test");
        Assert.assertTrue(false);
    }

    @Test(groups = {"dev", "stage"})
    public void smokerun(){
        System.out.println("smoke");
        Assert.assertTrue(false);
    }
}
