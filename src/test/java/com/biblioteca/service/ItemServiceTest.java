package com.biblioteca.service;


import com.biblioteca.exception.FormatIncorrectException;
import com.biblioteca.repository.ItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    private ItemService itemService;
    private ParseBookService parseBookService;

    @Before
    public void setUp() {
        itemService = new ItemService(itemRepository,parseBookService);
    }

    @Test
    public void shouldCallGetAllBooks() {
        itemService.getAllItems("book");
        verify(itemRepository, times(1)).getAllItems("book");
    }

    @Test
    public void shouldCallInsertOneOrManyBooks() throws FormatIncorrectException {
        //itemService.insertOneOrManyBooks("BooksBulk");
        //verify(itemRepository, times(1)).insertOneOrManyBooks(new ArrayList<>());
    }


}
