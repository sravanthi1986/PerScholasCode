package com.perscholas.junit_suit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestClassTwo {

	@Test
	public void methodTwo() {
		assertTrue("string".equals("string"));
		System.out.println("testclassTwo methodTwo");
	}
}
