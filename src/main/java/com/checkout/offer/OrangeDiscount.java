package com.checkout.offer;

import com.checkout.service.Discount;

/**
 * Below class is for 3 for the price 
 * of 2 on oranges
 * @author dusha
 *
 */
public class OrangeDiscount implements Discount{

	@Override
	public int offer(Integer[] items) {
		
		int totalItems = items.length;
		if(totalItems == 0) {
			return 0;
		}
		return (totalItems / 3) * 2 * items[0] + (totalItems % 3) * items[0];
	}

}
