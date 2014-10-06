package com.japerfect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.japerfect.entity.FoodOrder;

public interface OrderRepo extends JpaRepository<FoodOrder, Integer>{

	
	
}
