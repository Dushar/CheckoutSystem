package com.checkout;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import com.checkout.offer.OrangeDiscount;

public class TestOrangeDiscount {
	
	private OrangeDiscount orangeDiscount;
	
	@Before
	public void setUp() throws Exception {
		orangeDiscount = new OrangeDiscount();
	}
	
	//Checking 3 for the price of 2 on Oranges
	@Test
	public void test() {
		assertThat("Orange 1",orangeDiscount.offer(new Integer[]{60}), Is.is(60));
        assertThat("Orange 2",orangeDiscount.offer(new Integer[]{60,60}), Is.is(120));
        assertThat("Orange 3",orangeDiscount.offer(new Integer[]{60,60,60}), Is.is(120));
        assertThat("Orange 4",orangeDiscount.offer(new Integer[]{60,60,60,60}), Is.is(180));
	}

}
