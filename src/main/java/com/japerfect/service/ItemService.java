package com.japerfect.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.japerfect.entity.Item;
import com.japerfect.repository.ItemRepo;

@Service
@Transactional
public class ItemService  {

	@Autowired
	ItemRepo itemRepo ;

	public void saveOneItem(Item nItem) {
		itemRepo.save(nItem);
	}

	public Item getOneItem(int itemId) {
		return itemRepo.findOne(itemId);
	}

	public List<Item> getAll() {
		return itemRepo.findAll();
	}
	
}
