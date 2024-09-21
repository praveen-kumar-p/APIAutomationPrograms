package org.example.ex_21092024;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG001 {

    @Severity(SeverityLevel.NORMAL)
    @Description("verify that true == true")
    @Test
    public void testcase1(){
        Assert.assertEquals(true, true);

    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("verify that true != false")
    @Test
    public void testcase2(){
        Assert.assertEquals(true, false);

    }
}
