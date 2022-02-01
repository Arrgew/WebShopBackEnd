package com.arrgew.webshop.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.arrgew.webshop.model.Item;
import com.arrgew.webshop.repo.ItemRepo;

@Service
@Transactional
public class ItemService {
	private final ItemRepo itemRepo;
	
	@Autowired
	public ItemService(ItemRepo itemRepo) {
		this.itemRepo=itemRepo;
	}
	
	public Item addItem(Item newItem) {
		return itemRepo.save(newItem);
	}
	
	public List<Item> findAllItems(){
		return itemRepo.findAll();
	}
	
	public Item findItemById(Long id) {
		return itemRepo.findItemById(id).orElseThrow();
	}
	
	public Item updateItemById(Item updatedItem) {
		return itemRepo.save(updatedItem);
	}
	
	public void deleteItemById(Long id) {
		itemRepo.deleteItemById(id);
	}
}
