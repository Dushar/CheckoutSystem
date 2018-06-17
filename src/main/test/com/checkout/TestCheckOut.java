package com.checkout;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import com.checkout.service.DiscountServiceImpl;

public class TestCheckOut {
	
	private Checkout checkOut; 
	
	@Before
	public void setUp() throws Exception {
		checkOut = new Checkout(new DiscountServiceImpl());
	}

	@Test
	public void testTotalForAppleOrange() throws Exception {
		assertThat("1 Apple, 1 Orange", checkOut.checkOutItems(asList("apple", "orange")), Is.is("£0.85"));
		assertThat("3 Apple, 1 Orange", checkOut.checkOutItems(asList("apple", "apple", "orange", "apple" )), Is.is("£1.45"));
		assertThat("2 Apple, 3 Oranges", checkOut.checkOutItems(asList("apple", "apple", "orange", "orange", "orange")), Is.is("£1.10"));
		assertThat("4 Apple, 5 Oranges", checkOut.checkOutItems(asList("apple", "apple","apple", "apple", "orange", "orange", "orange", "orange", "orange")), Is.is("£2.20"));
	}
	
	@Test
	public void testOfferForApple() throws Exception {
		assertThat("1 Apple", checkOut.checkOutItems(asList("apple")), Is.is("£0.60"));
		assertThat("2 Apple", checkOut.checkOutItems(asList("apple")), Is.is("£0.60"));
		assertThat("3 Apple", checkOut.checkOutItems(asList("apple","apple","apple")), Is.is("£1.20"));
		assertThat("5 Apple", checkOut.checkOutItems(asList("apple","apple","apple","apple","apple")), Is.is("£1.80"));
	}
	
	@Test
	public void testOfferForOrange() throws Exception {
		assertThat("1 Orange", checkOut.checkOutItems(asList("orange")), Is.is("£0.25"));
		assertThat("2 Orange", checkOut.checkOutItems(asList("orange","orange")), Is.is("£0.50"));
		assertThat("3 Orange", checkOut.checkOutItems(asList("orange","orange","orange")), Is.is("£0.50"));
		assertThat("4 Orange", checkOut.checkOutItems(asList("orange","orange","orange","orange")), Is.is("£0.75"));
	}

}
