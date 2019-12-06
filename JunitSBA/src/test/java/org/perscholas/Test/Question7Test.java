package org.perscholas.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.perscholas.exam.AddVaryingTypeCalculator;

public class Question7Test {
	
	@Before
    public void setUp() throws Exception {
		AddVaryingTypeCalculator cal = new AddVaryingTypeCalculator();

    }

    @Test
    public void addingMultipleNumbersProducesResult() throws Exception {
    	AddVaryingTypeCalculator calculator = new AddVaryingTypeCalculator();

        int answer = calculator(1 ,2);

        assertEquals(3, answer);
    }

    private int calculator(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}

