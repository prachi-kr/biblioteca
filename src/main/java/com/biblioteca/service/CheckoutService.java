package com.biblioteca.service;

import com.biblioteca.model.Book;
import com.biblioteca.model.Checkout;
import com.biblioteca.repository.BookRepository;
import com.biblioteca.repository.CheckoutRepository;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    private BookRepository bookRepository;
    private CheckoutRepository checkoutRepository;

    public CheckoutService(BookRepository bookRepository, CheckoutRepository checkoutRepository) {
        this.bookRepository = bookRepository;
        this.checkoutRepository = checkoutRepository;
    }

    public void checkoutBook(String bookId) {
        Book book = bookRepository.getBook(bookId);
        checkoutRepository.checkoutBook(new Checkout(book));
    }


}
