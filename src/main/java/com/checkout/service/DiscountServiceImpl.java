package com.checkout.service;

import com.checkout.offer.AppleDiscount;
import com.checkout.offer.OrangeDiscount;

public class DiscountServiceImpl {
	
	public Discount discountService(String fruit) {
		
		if("Apple".equalsIgnoreCase(fruit)) {
			return new AppleDiscount();
		}else if("Orange".equalsIgnoreCase(fruit)) {
			return new OrangeDiscount();
		}else {
			throw new IllegalArgumentException("Item not listed for: "+fruit);
		}
		
	}
}
