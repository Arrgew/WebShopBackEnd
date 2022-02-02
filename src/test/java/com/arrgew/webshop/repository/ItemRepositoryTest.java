package com.arrgew.webshop.repository;

import com.arrgew.webshop.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void itShouldFindItemById() {
        //give
        Item item = new Item("testItem","the description of the testItem",156,"imgUrl's place");
        this.itemRepository.save(item);
        //when
        Optional<Item> itExists= this.itemRepository.findItemById(Long.parseLong("1"));
        //then
        assertEquals(item,itExists.get());
    }

    @Test
    void deleteItemById() {
        //give
        Item item = new Item("testItem","the description of the testItem",156,"imgUrl's place");
        this.itemRepository.save(item);
        Item item2 = new Item("testItem2","the description of the testItem2",15600,"imgUrl's place2");
        this.itemRepository.save(item2);
        //when
        this.itemRepository.deleteItemById(1L);
        //then
        assertFalse(itemRepository.existsById(1L));
        assertTrue(itemRepository.existsById(2L));
    }
}