package com.perscholas.unti;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.number.OrderingComparison.lessThan;

import org.hamcrest.Matcher;
import org.junit.Test;

import com.perscholas.SimpleClass;

public class SimpleClassHameCrustTest {
@Test
public void returnTrueTest() {
	SimpleClass sc=new SimpleClass();
	assertThat(sc.returnTrue(), is(true));
}
@Test
public void returnFalseTest() {
	SimpleClass sc=new SimpleClass();
	assertThat(sc.returnFalse(),is(not(true)));
}
@Test
public void returnNullTest() {
	SimpleClass sc=new SimpleClass();
	assertThat(sc.returnNull(),nullValue());
}
@Test
public void returnNotNullTest() {
	SimpleClass sc=new SimpleClass();
	assertThat(sc.returnNotNull(),notNullValue());
}
@Test
public void retuenoneTest() {
	SimpleClass sc=new SimpleClass();
	assertThat(sc.returnOne(),is (1));
	assertThat(sc.returnOne(),equalTo (1));
	assertThat(sc.returnOne(), allOf(not(2), lessThan(5)));
	assertThat(sc.returnOne(),sameInstance(1));
	assertThat(sc.returnOne(),anyOf(equalTo(1),not(equalTo(2))));
	
	
}
@Test
public void returnListTest() {
	SimpleClass sc=new SimpleClass();
	List<String> actual=sc.returnList();
	List<String> expected=Arrays.asList("red","green","blue");
	//test both the list are same
	assertThat(actual,is(expected));
	assertThat(actual,hasItems("red","green"));
	assertThat(actual,allOf(hasItems("red"),hasItems("green"),hasItems("blue")));
	assertThat(sc.returnList().get(0),allOf(startsWith("r"),endsWith("d")));
	assertThat(sc.returnList().get(0),anyOf(not(startsWith("r")),endsWith("d")));



}
@Test
public void returnHashMapTest() {
	SimpleClass sc=new SimpleClass();
	  Map<String,String> officers=sc.returnHashMap();
	  assertThat(officers, hasEntry("president", "Jane"));
	  assertThat(officers, hasKey("vicepresident"));
	  
}

}