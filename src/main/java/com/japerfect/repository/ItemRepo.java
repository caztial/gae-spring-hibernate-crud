package com.japerfect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.japerfect.entity.Item;



public interface ItemRepo extends JpaRepository<Item, Integer> {

	
}
