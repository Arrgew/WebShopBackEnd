package com.arrgew.webshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arrgew.webshop.model.Item;
import com.arrgew.webshop.service.ItemService;

@RestController
@RequestMapping(path="/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@PostMapping(path="/add")
	public ResponseEntity<Item> addNewItem(@RequestBody Item newItem) {
		itemService.addItem(newItem);
		return new ResponseEntity<>(newItem, HttpStatus.OK);
	}
	
	@GetMapping(path="/all")
	public ResponseEntity<List<Item>> getAllItems(){
		List<Item> items = itemService.findAllItems();
		return new ResponseEntity<>(items,HttpStatus.OK);
	}
	
	@GetMapping(path="/find/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable("id") Long id){
		return new ResponseEntity<>(itemService.findItemById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update")
    public ResponseEntity<Item> updateEmployee(@RequestBody Item updateItem) {
        return new ResponseEntity<>(itemService.updateItemById(updateItem), HttpStatus.OK);
    }
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable("id") Long id) {
		itemService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
