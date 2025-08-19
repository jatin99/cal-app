package com.cal.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cal.Calculator;

public class Calculator2TestCase {

	private Calculator c = new Calculator();

	@Test
	public void addTest() {
		Assert.assertEquals(c.add(10, 20), 30);
	}

	@Test
	public void subTest() {
		Assert.assertEquals(c.sub(10, 20), -10);
	}

	@Test
	public void mulTest() {
		Assert.assertEquals(c.mul(10, 20), 200);
	}

	@Test
	public void divTest() {
		Assert.assertEquals(c.div(10, 2), 5);
	}
}
