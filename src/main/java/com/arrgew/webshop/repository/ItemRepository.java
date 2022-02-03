package com.arrgew.webshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arrgew.webshop.model.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	
	Optional<Item> findItemById(Long id);
	void deleteItemById(Long id);
}
