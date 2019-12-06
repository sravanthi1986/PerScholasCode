package org.perscholas.junit_test;


	import java.util.Arrays;
	import java.util.Collection;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.junit.runners.Parameterized;
	import org.junit.runners.Parameterized.Parameters;
	import org.perscholas.junit.MaximumQuantityExceededException;
	import org.perscholas.junit.Product;
	
	@RunWith(Parameterized.class)
	
	public class ExceptionTest {
	     Product product;
	    int x;
	    public ExceptionTest(int x)
	    {
	        this.x = x;
	    }
	    @Parameters()
	    public static Collection<Object[]> data(){
	        return Arrays.asList(new Object[][]
	                    {
	                            {501},
	                            {1000},
	                            {700}
	                          
	                     });
	    }
	        
	    @Test(expected = MaximumQuantityExceededException.class)
	    public void maxQuantityExceptionTest() throws MaximumQuantityExceededException  {
	        product = new Product();
	        product.setAvailableQuantity(x);
	    }
	}