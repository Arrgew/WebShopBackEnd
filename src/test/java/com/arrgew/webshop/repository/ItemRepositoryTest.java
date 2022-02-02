package com.arrgew.webshop.repository;

import com.arrgew.webshop.model.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @AfterEach
    void tearDown(){
        this.itemRepository.deleteAll();
    }

    @Test
    void itShouldFindItemById() {
        //give
        Item item = new Item("testFindByIdItem","the description of the testFindByIdItem",652,"imgUrls place");
        this.itemRepository.save(item);
        //when
        Optional<Item> itExists= this.itemRepository.findItemById(item.getId());
        //then
        assertTrue(itExists.isPresent());
    }

    @Test
    void ItShouldDeleteItemByIdButNotOtherItems() {
        //give
        Item item = new Item("testDeleteItem","the description of the testDeleteItem",15646,"imgUrls place");
        this.itemRepository.save(item);
        Item item2 = new Item("testDeleteItem2","the description of the testDeleteItem2",15600,"imgUrls place2");
        this.itemRepository.save(item2);
        //when
        this.itemRepository.deleteItemById(item.getId());
        System.out.println(this.itemRepository.findAll());
        //then
        assertFalse(itemRepository.existsById(item.getId()));
        assertTrue(itemRepository.existsById(item2.getId()));
    }

    @Test
    void findAllItemsInDatabase(){
        //give
        Item item = new Item("testFindAllItem","the description of the testItem",156,"imgUrls place");
        Item item2 = new Item("testFindAllItem2","the description of the testItem",199,"imgUrls place");
        Item item3 = new Item("testFindAllItem3","the description of the testItem",2226,"imgUrls place");
        Item item4 = new Item("testFindAllItem4","the description of the testItem",9956,"imgUrls place");
        this.itemRepository.saveAll(List.of(item,item2,item3,item4));
        //when
        List<Item> itemList =itemRepository.findAll();
        //then
        assertTrue(item.equals(itemList.get(0))&item2.equals(itemList.get(1))&item3.equals(itemList.get(2))&item4.equals(itemList.get(3)));
    }
}