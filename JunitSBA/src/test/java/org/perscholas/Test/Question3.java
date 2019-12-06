package org.perscholas.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Question3 {
	
	@Test

	public void BinaryNumberTest() {
	assertEquals("1000", Integer.toBinaryString(8));
	assertEquals("10100", Integer.toBinaryString(20));
	assertEquals("1010", Integer.toBinaryString(10));
	assertEquals("1001", Integer.toBinaryString(9));
	
	}
}