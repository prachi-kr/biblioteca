package com.biblioteca.repository;

import com.biblioteca.Application;
import com.biblioteca.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void shouldReturnAllItems() {
        String itemType = "movie";
        assertEquals(itemRepository.getAllItems(itemType).size(),3);
    }

    @Test
    public void shouldReturnItem() {
        Item item = new Item("bb484940-3e2c-11e8-b566-0800200c9a66", "Harry Potter - The Philosphers stone", 2001,3,"book","978-3-16-148410-0,J. K. Rowling");
        assertEquals(itemRepository.getItem("bb484940-3e2c-11e8-b566-0800200c9a66"),item);
    }







}
