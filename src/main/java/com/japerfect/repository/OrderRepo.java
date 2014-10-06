package com.japerfect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.japerfect.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
