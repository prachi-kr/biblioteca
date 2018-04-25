package com.biblioteca.BookController;

import com.biblioteca.controller.BookController;
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

}
