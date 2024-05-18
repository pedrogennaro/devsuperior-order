package com.pedrogennaro.devsuperiororder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrogennaro.devsuperiororder.entities.Order;

@Service
public class OrderService {
	
	@Autowired
	ShippingService shippingService;
	
	public Double total(Order order) {

		double shipment = shippingService.shipment(order);
		double totalWithDiscount = totalDiscount(order.getBasic(), order.getDiscount());
				
		return totalWithDiscount + shipment;
	}
	
	private Double totalDiscount(double basic, double discount) {
		double valueDiscount = basic * discount/100;
		return basic - valueDiscount;
	}

}
