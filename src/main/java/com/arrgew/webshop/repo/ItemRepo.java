package com.arrgew.webshop.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arrgew.webshop.model.Item;

public interface ItemRepo extends JpaRepository<Item, Long>{
	
	Optional<Item> findItemById(Long id);
	void deleteItemById(Long id);

}
