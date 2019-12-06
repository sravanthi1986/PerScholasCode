package org.perscholas.junit_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.perscholas.junit.math;

public class MathTest {

	@Test
	public void addTest() {
		math ma = new math();
		assertEquals(6, ma.add(3, 3));
	}

	@Test
	public void subTest() {
		math ma = new math();
		assertSame(2, ma.sub(6, 4));
	}

	// or
	public void subTest1() {
		math ma = new math();
		int answer = 6;
		boolean result;
		if (answer == ma.sub(12, 6)) {
			result = true;
		} else {
			result = false;
		}
		assertTrue(result);
	}

	@Test
	public void mulTest() {
		math ma = new math();
		assertNotEquals(6, ma.mul(3, 3));
	}

	@Test
	public void divTest() {
		math ma = new math();
		assertNotSame(6, ma.add(9, 3));
	}
}
