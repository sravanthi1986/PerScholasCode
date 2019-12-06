package com.perscholas.unti;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.perscholas.SimpleClass;

public class SimpleClassTest {
  @Test
  public void returnTrueTest() {
	  SimpleClass sc=new SimpleClass();
	  assertTrue(sc.returnTrue());
	  //second way
	  //boolean actual=sc.returnTrue(1;
	  //assertTrue(actual);
	  
  }
  @Test
  public void returnNullTest() {
	  SimpleClass sc=new SimpleClass();
	  assertNull(sc.returnNull());
  }
  @Test
  public void returnOne() {
	  SimpleClass sc=new SimpleClass();
	  assertEquals(sc.returnOne(),1);
	 
  }
  @Test
  public void returnList() {
	  SimpleClass sc=new SimpleClass();
	 assertThat(sc.returnList(),hasItems("red","green","blue"));
	  //or
	  assertTrue(sc.returnList().get(0).equals("red"));
	  //or
	  assertTrue(sc.returnList().getClass().toString().equals("class java.util.ArrayList"));
      System.out.println(sc.returnList().getClass().equals("class java.util.ArrayList"));
  }
  
  
  @Test
  public void returnHashMapTest() {
	  SimpleClass sc=new SimpleClass();
	  Map<String,String> actual=sc.returnHashMap();
	  Map<String,String> expected=new HashMap<String,String>();
	  expected.put("president", "Jane");
	  expected.put("vice president", "James");
	  expected.put("secretary", "Jennifer");
	  expected.put("treasurer", "John");
	  assertEquals(actual,expected);

  }
}
