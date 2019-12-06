package org.perscholas.junit_test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.collection.IsMapContaining;

import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;

import org.junit.Test;
import org.perscholas.junit.MathHam;

public class MathHamTest {

	@Test
	public void addtest() {
		MathHam mh = new MathHam();
		assertThat(6, is(mh.add(4, 2)));
		assertThat(6, allOf(greaterThan(4), lessThan(7)));

	}

	@Test
	public void subtest() {
		MathHam mh = new MathHam();
		assertThat(5, is(mh.add(3, 2)));
		assertThat(5, allOf(greaterThan(3), lessThan(7)));

	}

	@Test
	public void listtest() {
		MathHam mh = new MathHam();
	
	assertThat(mh.listClass(), hasItem(5));
		assertThat(mh.listClass(), contains(5, 2, 4));

       assertThat(mh.listClass(), containsInAnyOrder(2, 4, 5));

	}

	@Test
	public void mapmathTest() {
		MathHam mh = new MathHam();
		assertThat(mh.mapmath(), IsMapContaining.hasKey(10));
		assertThat(mh.mapmath(), hasEntry(25, 11));
		assertThat(mh.mapmath(), IsMapContaining.hasValue(34));
		assertThat(mh.mapmath(), IsMapContaining.hasEntry(20, 34));

	}

}