package com.biblioteca.repository;

import com.biblioteca.Application;
import com.biblioteca.model.Book;
import com.biblioteca.model.Checkout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CheckoutRepositoryTest {

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Test
    public void shouldBeAbleToMakeEntryInCheckoutTable() {
        int initialSize = checkoutRepository.getAllCheckouts().size();
        checkoutRepository.checkoutBook(new Checkout(new Book("ba0bd157-e668-4d7e-a0a9-af5fb86222b7", "title", "author", 0, "isbn")));
        assertEquals(checkoutRepository.getAllCheckouts().size(), initialSize + 1);

    }
}