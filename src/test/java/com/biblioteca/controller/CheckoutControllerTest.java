package com.biblioteca.controller;

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
    public void shouldBeAbleToCheckout() {
        CheckoutController checkoutController = new CheckoutController(checkoutService);
        checkoutController.checkoutBook("ba0bd157-e668-4d7e-a0a9-af5fb86222b7");
        verify(checkoutService, times(1)).checkoutBook("ba0bd157-e668-4d7e-a0a9-af5fb86222b7");
    }
}