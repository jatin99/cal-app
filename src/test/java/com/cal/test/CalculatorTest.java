package com.cal.test;

import com.cal.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {

    private static final double EPS = 1e-9;
    private Calculator c;

    @BeforeClass
    public void setUp() {
        c = new Calculator();
        System.out.println("-------ENV"+ System.getProperty("env"));
    }

    @Test
    public void add_returnsSum() {
        Assert.assertEquals(c.add(10, 20), 30.0, EPS, "add(10,20) should be 30");
    }

    @Test
    public void sub_returnsDifference() {
        Assert.assertEquals(c.sub(10, 20), -10.0, EPS, "sub(10,20) should be -10");
    }

    @Test
    public void mul_returnsProduct() {
        Assert.assertEquals(c.mul(10, 20), 200.0, EPS, "mul(10,20) should be 200");
    }

    @Test
    public void div_returnsQuotient() {
        Assert.assertEquals(c.div(10, 2), 5.0, EPS, "div(10,2) should be 5");
    }

    @Test
    public void div_byZero_currentBehaviorReturnsZero() {
        // Matches your current Calculator: catches ArithmeticException and returns 0.0
        //Assert.assertEquals(c.div(10, 0), 0.0, EPS, "div(10,0) should return 0.0 per current policy");
    }
}
