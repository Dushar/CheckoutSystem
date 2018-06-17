package com.checkout;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Test;

import com.checkout.offer.AppleDiscount;
import com.checkout.offer.OrangeDiscount;
import com.checkout.service.DiscountServiceImpl;

public class TestDiscountServiceImpl {
	
	private DiscountServiceImpl discount;

	@Before
	public void setUp() throws Exception {
		discount = new DiscountServiceImpl();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testOtherFruitItem() {
		assertThat(discount.discountService("strawberry"), IsInstanceOf.instanceOf(IllegalArgumentException.class));
	}
	
	@Test
	public void testAppleDiscount() {
		assertThat(discount.discountService("apple"), IsInstanceOf.instanceOf(AppleDiscount.class));
	}
	
	@Test
	public void testOrangeDiscount() {
		assertThat(discount.discountService("orange"), IsInstanceOf.instanceOf(OrangeDiscount.class));
	}
	
}
