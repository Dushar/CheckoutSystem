package com.checkout;

import static java.util.Collections.nCopies;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;

import com.checkout.service.DiscountServiceImpl;

public class Checkout {
	
	private static final int APPLE_PRICE = 60;
	private static final int ORANGE_PRICE = 25;
	private static final String APPLE = "apple";
	private static final String ORANGE = "orange";
	
	private DiscountServiceImpl discount;
	
	public Checkout(DiscountServiceImpl discount) {
		this.discount = discount;
	}
	
	private int calculateTotal(List<String> item) {
		int count = 0;
		
		//Sorting the given items
		Collections.sort(item);
		
		int appleOffer = Collections.frequency(item, APPLE);//Is used to get the frequency of element present in the specified list of Collection
		count += discount.discountService(APPLE).offer(nCopies(appleOffer, APPLE_PRICE).toArray(new Integer[appleOffer]));
		
		int orangeOffer = Collections.frequency(item, ORANGE);
		count += discount.discountService(ORANGE).offer(nCopies(orangeOffer, ORANGE_PRICE).toArray(new Integer[orangeOffer]));
		
		return count;
	}
	
	public String checkOutItems(List<String> item) {
		
		BigDecimal total = new BigDecimal(calculateTotal(item) * .01);
		return NumberFormat.getCurrencyInstance().format(total);
	}
}
