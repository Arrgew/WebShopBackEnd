package com.arrgew.webshop.service;

import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;

import com.arrgew.webshop.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.arrgew.webshop.model.Item;
import com.arrgew.webshop.repository.ItemRepository;

@Service
@Transactional
public class ItemService {
	private final ItemRepository itemRepository;
	
	@Autowired
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository =itemRepository;
	}
	
	public Item addItem(Item newItem) {
		return itemRepository.save(newItem);
	}
	
	public List<Item> findAllItems(){
		return itemRepository.findAll();
	}
	
	public Item findItemById(Long id) {
		return itemRepository.findItemById(id).orElseThrow();
	}
	
	public Item updateItemById(Item updatedItem) {
		return itemRepository.save(updatedItem);
	}
	
	public void deleteItemById(Long id) {
		itemRepository.deleteItemById(id);
	}

	public void addTagById(Long id,String tag){

	}
}
