package com.japerfect.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.japerfect.entity.FoodOrder;
import com.japerfect.entity.Item;
import com.japerfect.repository.OrderRepo;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	OrderRepo orderRepo;

	public void saveOneItem(FoodOrder order) {
		orderRepo.save(order);
	}

	public  List<FoodOrder> getAll() {
		return orderRepo.findAll();
	}

	public FoodOrder getOneOrder(int id) {
		return orderRepo.findOne(id);
	}
	
}
