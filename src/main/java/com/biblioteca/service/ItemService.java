package com.biblioteca.service;

import com.biblioteca.exception.FormatIncorrectException;
import com.biblioteca.model.Item;
import com.biblioteca.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;
    private ParseBookService parseBookService;

    @Autowired
    public ItemService(ItemRepository itemRepository, ParseBookService parseBookService) {
        this.itemRepository = itemRepository;
        this.parseBookService = parseBookService;
    }

    public List<Item> getAllItems(String itemType) {
        return itemRepository.getAllItems(itemType);
    }

    public void insertOneOrManyBooks(String booksString) throws FormatIncorrectException {
      //  List<Item> items = parseBookService.parseBooks(booksString);
      //  itemRepository.insertOneOrManyBooks(items);
    }
}
