package com.perscholas.junit_suit;

	import static org.junit.Assert.assertThat;

	import org.junit.Test;
	import org.junit.experimental.categories.Category;
	import static org.hamcrest.CoreMatchers.equalTo;

	@Category( { MondayMorningTests.class, WednesdayMorningTests.class } )
	public class EspressoTests {
		
		@Test
		public void espressoTest1() {
			Boolean stayAwake = true;
			assertThat(stayAwake, equalTo(true));
		}
		
	}


