package com.arrgew.webshop.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @Disabled
    void addNewItem() {
        RequestBuilder request = MockMvcRequestBuilders.post("/item/add");


    }

    @Test
    @Disabled
    void getAllItems() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/item/all");
        MvcResult result = mvc.perform(request).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @Disabled
    void getItemById() {
    }

    @Test
    @Disabled
    void updateItem() {
    }

    @Test
    @Disabled
    void deleteItem() {
    }
}