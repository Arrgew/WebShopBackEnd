package com.arrgew.webshop.service;

import com.arrgew.webshop.model.Item;
import com.arrgew.webshop.repository.ItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock private ItemRepository itemRepository;
    private ItemService itemService;

    @BeforeEach
    void setUp(){
        itemService = new ItemService(itemRepository);
    }

    @Test
    void canAddItem() {
        //give
        Item item = new Item("testAddItem","the description of the testAddItem",new BigDecimal(64252),"imgUrls place",null);
        //when
        itemService.addItem(item);
        //then
        ArgumentCaptor<Item> itemArgumentCaptor = ArgumentCaptor.forClass(Item.class);
        verify(itemRepository).save(itemArgumentCaptor.capture());
        Item captured = itemArgumentCaptor.getValue();
        assertEquals(captured,item);
    }

    @Test
    void shouldFindAllItems() {
        //when
        itemService.findAllItems();
        //then
        verify(itemRepository).findAll();
    }

    @Test
    @Disabled
    void findItemById(){

    }

    @Test
    @Disabled
    void updateItemById() {
    }

    @Test
    @Disabled
    void deleteItemById() {
    }
}