package com.biblioteca.repository;

import com.biblioteca.Application;
import com.biblioteca.model.Item;
import com.biblioteca.model.Checkout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

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
        Item item =  new Item("ba0bd157-e668-4d7e-a0a9-af5fb86222b7", "title", 2000, 5, "book","12345678");
        Timestamp dateOfIssue=new Timestamp(System.currentTimeMillis());
        Timestamp dateOfReturn=new Timestamp(System.currentTimeMillis());
        String uuid = String.valueOf(UUID.randomUUID());
        Checkout checkout = new Checkout(item);
        checkoutRepository.checkoutItem(checkout);
        assertEquals(checkoutRepository.getAllCheckouts().size(), initialSize + 1);
    }

//    @Test
//    public void shouldGetAllCheckouts(){
//        Item item = new Item("title",2000,3, "book", "");
//        Item newItem = itemRepository.addItem(item);
//        assertEquals(newItem.toString(),(item.toString()));
//    }
//
//       @Test
//    public void shouldGetTotalCheckoutsForItem() {
//        Item item = new Item();
//        item.setId("68242f83-7f38-4a69-85ef-8ec6101ab732");
//        checkoutRepository.addCheckout(new Checkout(item, null));
//        assertEquals(checkoutRepository.getCheckouts("68242f83-7f38-4a69-85ef-8ec6101ab732").size()).isEqualTo(1);
//    }
//
//    @Test
//    public void shouldUpdateDateOfReturnforItem() {
//        Checkout checkout = new Checkout(new Item(), null);
//        checkoutRepository.addCheckout(checkout);
//        String checkoutId = checkout.getId();
//
//        assertEquals(checkoutRepository.getCheckout(checkoutId).getId()).isEqualTo(checkoutId);
//    }

}