package com.perscholas.junit_suit;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.hamcrest.CoreMatchers.equalTo;
@Category( { SaturdayMorningTests.class } )
public class CappuccinoTests {

	@Category( { WednesdayMorningTests.class } )
	@Test
	public void cappuccinoTest1() {
		Boolean tastesSweet = true;
		assertThat(tastesSweet, equalTo(true));
	}
	
	@Test
	public void cappuccinoTest2() {
		Boolean frothy = true;
		assertThat(frothy, equalTo(true));
	}
}
