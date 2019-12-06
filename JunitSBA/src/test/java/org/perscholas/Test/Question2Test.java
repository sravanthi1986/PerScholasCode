package org.perscholas.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;



import org.junit.Test;

public class Question2Test {
	
	@Test
	public void SplitTest() {
	String s = "Welcome,to,Per Scholas";
	String[] str1 = new String[] { "Welcome", "to", "Per Scholas" };
	
	assertArrayEquals(str1, s.split(",",3));
	
	}
	@Test
	public void JoinedArrayTest() {
	String[] strArray = { "Im", "A", "Good", "Girl" };
	StringBuilder stringBuilder = new StringBuilder();
	for (int i = 0; i < strArray.length; i++) {
	stringBuilder.append(strArray[i]);
	}
	String joinedString = stringBuilder.toString();
	assertEquals("ImAGoodGirl", joinedString);
}
}