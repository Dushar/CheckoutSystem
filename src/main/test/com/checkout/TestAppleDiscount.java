package com.checkout;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import com.checkout.offer.AppleDiscount;

public class TestAppleDiscount {
	
	private AppleDiscount appleDiscount;
	
	@Before
	public void setUp() throws Exception {
		appleDiscount = new AppleDiscount();
	}
	
	//Checking apple offer for buy1 get1 offer
	@Test
	public void testAppleOffer() {
		assertThat("Apple 1", appleDiscount.offer(new Integer[]{60}), Is.is(60));
		assertThat("Apple 2", appleDiscount.offer(new Integer[]{60,60}), Is.is(60));
		assertThat("Apple 3", appleDiscount.offer(new Integer[]{60,60,60}), Is.is(120));
		assertThat("Apple 4", appleDiscount.offer(new Integer[]{60,60,60,60}), Is.is(120));
	}

}
