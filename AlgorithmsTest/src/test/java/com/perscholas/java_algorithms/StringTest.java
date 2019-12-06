package com.perscholas.java_algorithms;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringTest {

	@Test
	public void returnArrTest() {
		StringAlg sa = new StringAlg();
		assertTrue(sa.returnWords().length == 3);

	}

	@Test
	public void returnArrTest2() {
		StringAlg sa = new StringAlg();
		System.out.println(sa.returnWords()[0]);
		assertFalse(sa.returnWords()[0].equals("Hell"));
	}

}
