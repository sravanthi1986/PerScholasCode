package org.perscholas.Test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.perscholas.exam.InvalidPasswordException;
import org.perscholas.exam.User;


public class Question6Test {
	
public static User testObject;
    
    //Sets up the test object used in the tests
    @BeforeClass
    public static void setUpObject() {
        
        testObject = new User();
        
    }
    
    //This test expects an exception from the specified class
    @Test(expected = InvalidPasswordException.class)
    public void testInsufficientException() throws InvalidPasswordException {
        
        //Throws exception just to see if test works
        //Actual code that throws an exception would go here!
            
        testObject.calculateCredits();
        
        
        
    }
    
}
