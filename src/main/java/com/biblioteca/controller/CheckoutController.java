package com.biblioteca.controller;

import com.biblioteca.exception.ItemOutOfStockException;
import com.biblioteca.exception.InvalidItemException;
import com.biblioteca.exception.InvalidReturnException;
import com.biblioteca.model.Checkout;
import com.biblioteca.model.DateInput;
import com.biblioteca.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CheckoutController {

    private CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @RequestMapping(value = "/items/{itemId}/checkout")
    public Checkout checkoutBook(@PathVariable("itemId") String itemId) throws ItemOutOfStockException, InvalidItemException {
        return checkoutService.checkoutItem(itemId);
    }

    @RequestMapping(value = "/items/{itemId}/checkout/{checkoutId}/returnItem",method = RequestMethod.POST)
    public Checkout returnCheckedoutItem(@PathVariable("itemId") String itemId, @PathVariable("checkoutId") String checkoutId, @RequestBody DateInput date) throws InvalidItemException, InvalidReturnException {
        return checkoutService.returnCheckedoutItem(itemId,checkoutId,date.getDate());
    }

}
