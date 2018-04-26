package com.biblioteca.service;

import com.biblioteca.model.Book;
import com.biblioteca.model.Checkout;
import com.biblioteca.repository.BookRepository;
import com.biblioteca.repository.CheckoutRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutServiceTest {

    @Mock
    private CheckoutRepository checkoutRepository;

    @Mock
    private BookRepository bookRepository;

    @Captor
    private ArgumentCaptor<Checkout> checkoutDetailsArgumentCaptor;

    @Test
    public void shouldBeAbleToMakeCheckoutABook() {
        Book book = new Book("ba0bd157-e668-4d7e-a0a9-af5fb86222b7",
                "The Goblet of Fire",
                "J K Rowling",
                2001,
                "978-3-16-148410-0");
        when(bookRepository.getBook(book.getId())).thenReturn(book);

        CheckoutService checkoutService = new CheckoutService(bookRepository, checkoutRepository);
        checkoutService.checkoutBook("ba0bd157-e668-4d7e-a0a9-af5fb86222b7");

        verify(bookRepository).getBook("ba0bd157-e668-4d7e-a0a9-af5fb86222b7");
        verify(checkoutRepository, times(1)).checkoutBook(checkoutDetailsArgumentCaptor.capture());

        Checkout checkout = checkoutDetailsArgumentCaptor.getValue();

        assertEquals(checkout.getBookId(), ("ba0bd157-e668-4d7e-a0a9-af5fb86222b7"));
    }
}