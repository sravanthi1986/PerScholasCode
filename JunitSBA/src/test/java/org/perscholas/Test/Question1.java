package org.perscholas.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import junit.framework.Assert;

public class Question1 {
	
	
	@Test
	public void EqualsIgnoreCaseTest() {
		String str1 = "Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201";
		String str2 = "PER Scholas - 211 N Ervay St. #700 - Dallas, TX 75201";
		// Test for equality while ignoring case
		assertThat(str1, equalToIgnoringCase(str2));
		assertThat(str1, containsString("211 N"));
		
		
	}
	@Test
	public void testLength() {
		String str1 = "Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201";
           int lengthactual=str1.length();
           int lengthExpected=53;
           assertEquals(lengthExpected,lengthactual);

	}
	@Test
	public void ContainsTest() {
	String str1 = "Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201";
	String str2 = "N Ervay";
  assertThat(str1, containsString(str2));
	}
	@Test
	public void StartswithTest() {
 String str1 = "Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201";
 String str2 = "Per Scholas";
	assertThat(str1, startsWith(str2));
	}
	@Test
	public void EndswithTest() {
	String str1 = "Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201";
		String str2 = "75201";
	assertThat(str1, endsWith(str2));
	}
	@Test
	public void charAtTest() {
		String str1 = "Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201";
		
		assertEquals( str1.charAt(0), 'P' );
		 
	}
	public void lowerCaseTest() {
		String str1 = "Per Scholas";
	assertEquals("per scholas",str1.toLowerCase());

	}
	
		
	
	
	}


