package org.perscholas.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;
import org.perscholas.exam.Product;



public class Question8Test {
	@Test
    public void getnameTest() {
    	Product absCls = Mockito.mock(
    			Product.class, 
    		      Mockito.CALLS_REAL_METHODS);
   
//testing getname method
    	  
  assertEquals("testA", absCls.getName());
    	    

    	 
    	 

}
	}
