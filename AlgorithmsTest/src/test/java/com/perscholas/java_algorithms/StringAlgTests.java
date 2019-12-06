package com.perscholas.java_algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class StringAlgTests {
	/* Declare an instance of StringAlg. The instance must be static 
	 * because we will initialize it in the setup() method which is a 
	 * static method. */
	private static StringAlg sa;
	
	/* The @BeforeClass annotation is known as a "test fixture". The "setup() 
	 * method will run only once before all the tests are initiated. This 
	 * allows us to instantiate the StringAlg instance only once which save 
	 * us from having to instantiate it in each test method. A method 
	 * annotated with @BeforeClass must be static. */
	@BeforeClass
	public static void setup() {
		// Initialise the "sa" variable
		sa = new StringAlg();
	}
	@Test
	public void returnWordsTest() {
		assertTrue(sa.returnWords().length == 3);
		assertTrue(sa.returnWords()[0].equals("Hello"));
	}
	@Test
	public void returnStringFromArrayTest() {
		assertTrue(sa.returnStringFromArray().equals("Hello-2019-QE02!"));
	}
	@Test
	public void arrayToListDemo() {
		/* List and classes that implement the List interface (e.g., ArrayList) 
		 * include a contains() method which allows us to test for elements 
		 * inside the list. */
		assertTrue(sa.arrayToListDemo().contains("Hello"));
	}
}
