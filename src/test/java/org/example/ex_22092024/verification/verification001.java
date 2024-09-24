package org.example.ex_22092024.verification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class verification001 {
    @Test
    public void test_verify(){

        String responseName = "Pramod";
        Assert.assertEquals("Pramod", responseName);
    }
}
