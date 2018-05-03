package com.biblioteca.controller;

import com.biblioteca.exception.InvalidReturnException;
import com.biblioteca.exception.ItemOutOfStockException;
import com.biblioteca.exception.InvalidItemException;
import com.biblioteca.model.DateInput;
import com.biblioteca.service.CheckoutService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutControllerTest {

    @Mock
    private CheckoutService checkoutService;

    @Test
    public void shouldBeAbleToCheckoutItem() throws ItemOutOfStockException, InvalidItemException {
        String itemId = "ba0bd157-e668-4d7e-a0a9-af5fb86222b7";

        CheckoutController checkoutController = new CheckoutController(checkoutService);
        checkoutController.checkoutBook(itemId);

        verify(checkoutService, times(1)).checkoutItem(itemId);
    }

    @Test
    public void shouldBeAbleToReturnItem() throws ItemOutOfStockException, InvalidItemException, InvalidReturnException {
        String itemId = "ba0bd157-e668-4d7e-a0a9-af5fb86222b7";
        String checkoutId = "6115c337-afdf-4976-9b22-e0208586867b";
        DateInput date = new DateInput();

        CheckoutController checkoutController = new CheckoutController(checkoutService);
        checkoutController.returnCheckedoutItem(itemId, checkoutId, date);

        verify(checkoutService, times(1)).returnCheckedoutItem(itemId, checkoutId,new DateInput().getDate());
    }
}