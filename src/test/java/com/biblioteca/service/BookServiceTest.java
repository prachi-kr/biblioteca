package com.biblioteca.service;


import com.biblioteca.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class  BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @Before
    public void setUp() {
        bookService = new BookService(bookRepository);
    }

    @Test
    public void shouldCallGetAllBooks() {
        bookService.getAllBooks();
        verify(bookRepository, times(1)).getAllBooks();
    }




}
