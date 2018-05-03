package com.biblioteca.service;

import com.biblioteca.exception.ItemOutOfStockException;
import com.biblioteca.exception.InvalidItemException;
import com.biblioteca.exception.InvalidReturnException;
import com.biblioteca.model.Item;
import com.biblioteca.model.Checkout;
import com.biblioteca.repository.ItemRepository;
import com.biblioteca.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CheckoutService {

    private ItemRepository itemRepository;
    private CheckoutRepository checkoutRepository;

    @Autowired
    public CheckoutService(ItemRepository itemRepository, CheckoutRepository checkoutRepository) {
        this.itemRepository = itemRepository;
        this.checkoutRepository = checkoutRepository;
    }

    public Checkout checkoutItem(String itemId) throws InvalidItemException,ItemOutOfStockException {
        Item item = itemRepository.getItem(itemId);
        if(item == null){
            throw new InvalidItemException(itemId);
        }
        int totalAvailability = item.getTotalAvailability();
        int totalCheckoutsForBook = checkoutRepository.getTotalCheckoutsForItem(item);

        if (totalAvailability > totalCheckoutsForBook)
            return checkoutRepository.checkoutItem(new Checkout(item));
        throw new ItemOutOfStockException();
    }

    public Checkout returnCheckedoutItem(String itemId, String checkoutId, Date date) throws InvalidReturnException {
        Item item = itemRepository.getItem(itemId);
        if(item == null){
            throw new InvalidItemException(itemId);
        }
        Checkout checkout = checkoutRepository.getCheckout(checkoutId);
        if(checkout == null){
            throw new InvalidReturnException("Checkout Id is not valid");
        }
        if(checkout.getDateOfReturn()!=null){
            throw new InvalidReturnException("Item is already returned");
        }
        if(item.getId()!=checkout.getItemId()){
            throw new InvalidReturnException("Item Id does not match Checkout Id");
        }
        return checkoutRepository.updateDateOfReturnforItem(checkout, date);
    }
}
