package com.biblioteca.controller;

import com.biblioteca.exception.FormatIncorrectException;
import com.biblioteca.service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

    @Mock
    private ItemService itemService;

    private ItemController itemController;

    @Before
    public void setUp() {
        itemController = new ItemController(itemService);
    }

    @Test
    public void shouldCallGetAllBooks() {
        itemController.getAllItems("books");
        verify(itemService, times(1)).getAllItems("books");
    }

    @Test
    public void shouldCallInsertOneOrManyBooks() throws FormatIncorrectException {
        itemController.insertOneOrManyBooks("booksBulk");
        verify(itemService, times(1)).insertOneOrManyBooks("booksBulk");
    }


}
