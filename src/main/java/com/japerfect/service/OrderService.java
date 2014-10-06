package com.japerfect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.japerfect.repository.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderRepo;
	
}
