package org.perscholas.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.perscholas.exam.ListMapClass;

public class Question5ListMapTest {
	
	@Test
	  public void returnHashMapTest() {
		ListMapClass lm=new ListMapClass();
		 assertThat(lm.cities(),hasItems("Dallas","Irving","Boston"));
		  
		 assertTrue(lm.cities().get(0).equals("Dallas"));
		 assertTrue(lm.cities().getClass().toString().
				 equals("class java.util.ArrayList"));
		 assertEquals("Dallas", lm.cities().get(0));
		 
		 

	  }
//   
	@Test
	  public void getCoursesMap() {
		ListMapClass sc=new ListMapClass();
		  Map<String,String> actual=sc.getCoursesMap();
		  Map<String,String> expected=new HashMap<String,String>();
		  expected.put("ASM", "Application Support Management");
		  expected.put("DE", "Data Engineering");
		  expected.put("JD", "Java Developer");
		  expected.put("QEA", "Quality Engineering and Assurance");
		  assertEquals(actual,expected);

	  }
	
}
