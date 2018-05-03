package com.biblioteca.service;

import com.biblioteca.exception.ItemOutOfStockException;
import com.biblioteca.exception.InvalidItemException;
import com.biblioteca.model.Item;
import com.biblioteca.model.Checkout;
import com.biblioteca.repository.ItemRepository;
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
    private ItemRepository itemRepository;

    @Captor
    private ArgumentCaptor<Checkout> checkoutDetailsArgumentCaptor;

    @Test
    public void shouldBeAbleToCheckoutABook() throws ItemOutOfStockException, InvalidItemException {
        Item item = new Item("ba0bd157-e668-4d7e-a0a9-af5fb86222b7",
                "The Goblet of Fire",
                2001,
                5,
                "book","7391634402");
        when(itemRepository.getItem(item.getId())).thenReturn(item);

        CheckoutService checkoutService = new CheckoutService(itemRepository, checkoutRepository);
        checkoutService.checkoutItem("ba0bd157-e668-4d7e-a0a9-af5fb86222b7");

        verify(itemRepository).getItem("ba0bd157-e668-4d7e-a0a9-af5fb86222b7");
        verify(checkoutRepository, times(1)).checkoutItem(checkoutDetailsArgumentCaptor.capture());

        Checkout checkout = checkoutDetailsArgumentCaptor.getValue();

        assertEquals(checkout.getItemId(), ("ba0bd157-e668-4d7e-a0a9-af5fb86222b7"));
    }

    @Test(expected = InvalidItemException.class)
    public void shouldThrowExceptionForCheckingOutInvalidBook() throws ItemOutOfStockException, InvalidItemException {
        Item item = new Item(null,
                "The Goblet of Fire",
                2001,
                5,
                "book","7391634402");

        CheckoutService checkoutService = new CheckoutService(itemRepository, checkoutRepository);
        checkoutService.checkoutItem("ba0bd157-e668-4d7e-a0a9-af5fb86222b7");
    }

    @Test(expected = ItemOutOfStockException.class)
    public void shouldThrowItemOutOfStockExceptionWhenItemCheckedOutIsNotAvailable() throws ItemOutOfStockException, InvalidItemException {
        Item item = new Item("ba0bd157-e668-4d7e-a0a9-af5fb86222b7",
                "The Goblet of Fire",
                2001,
                1,
                "book", "7391634402");
        when(itemRepository.getItem(item.getId())).thenReturn(item);
        when(checkoutRepository.getTotalCheckoutsForItem(item)).thenReturn(1);
        CheckoutService checkoutService = new CheckoutService(itemRepository, checkoutRepository);
        checkoutService.checkoutItem("ba0bd157-e668-4d7e-a0a9-af5fb86222b7");
    }


}