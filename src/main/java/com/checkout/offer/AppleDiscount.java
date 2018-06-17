package com.checkout.offer;

import com.checkout.service.Discount;

/**
 * Below class is for apple discount buying one 
 * and getting one free
 * @author dusha
 *
 */
public class AppleDiscount implements Discount{

	@Override
	public int offer(Integer[] items) {
		int totalItems = items.length;
		if(totalItems == 0) {
			return 0;
		}
		return (totalItems /2)* items[0] + (totalItems %2)* items[0];
	}

}
