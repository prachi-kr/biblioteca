package com.biblioteca.controller;

import com.biblioteca.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    @Mock
    private BookService bookService;

    private BookController bookController;

    @Before
    public void setUp() {
        bookController = new BookController(bookService);
    }

    @Test
    public void shouldCallGetAllBooks() {
        bookController.getAllBooks();
        verify(bookService, times(1)).getAllBooks();
    }

//    @Test
//    public void shouldBeAbleToCheckout() {
//        bookController.checkoutBook("ba0bd157-e668-4d7e-a0a9-af5fb86222b7");
//        verify(bookService, times(1)).checkoutBook(new Checkout("ba0bd157-e668-4d7e-a0a9-af5fb86222b7"));
//    }




//    @Test
//    public void shouldReturnInvalidOption() {
//        assertEquals(bookController.throwExp(),"Select a valid option!");
//    }

}
