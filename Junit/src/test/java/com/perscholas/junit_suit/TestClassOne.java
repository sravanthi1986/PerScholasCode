package com.perscholas.junit_suit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestClassOne {

	@Test
	public void methodOne() {
		assertTrue("string".equals("string"));
		System.out.println("testclassone methodone");
	}
}
