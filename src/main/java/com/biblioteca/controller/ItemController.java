package com.biblioteca.controller;

import com.biblioteca.exception.FormatIncorrectException;
import com.biblioteca.model.Item;
import com.biblioteca.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/{itemType}")
    public List<Item> getAllItems(@PathVariable("itemType") String itemType) {
        return itemService.getAllItems(itemType);
    }

    @RequestMapping(value = "/insertMultipleBooks")
    public void insertOneOrManyBooks(@RequestBody String booksInBulk) throws FormatIncorrectException {
        itemService.insertOneOrManyBooks(booksInBulk);
    }
}
