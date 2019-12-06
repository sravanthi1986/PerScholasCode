package org.perscholas.junit_test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import ques6.parameterizedDAO.clas.Greetings;


public  class GreetingsMockTest {

		    @Test
		    public void shouldFailOnNullIdentifiers() {
		    	Greetings absCls = Mockito.mock(
		    			Greetings.class, 
		    		      Mockito.CALLS_REAL_METHODS);
		    		  
		    		    assertEquals("English", absCls.selectLanguage(1));
		    }
		
}
