package com.japerfect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.japerfect.entity.FoodOrder;
import com.japerfect.repository.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderRepo;

	public void saveOneItem(FoodOrder order) {
		orderRepo.save(order);
	}
	
}
