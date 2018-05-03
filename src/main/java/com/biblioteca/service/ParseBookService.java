package com.biblioteca.service;

import com.biblioteca.exception.FormatIncorrectException;
import com.biblioteca.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ParseBookService {

    private BooksValidationService booksValidationService;


//    public List<Item> parseBooks(String bookString) throws FormatIncorrectException {
//        List<Item> items = new ArrayList<>();
//        booksValidationService = new BooksValidationService();
//        String[] stringArrayOfBooks = bookString.split("\\r?\\n");
//        for (int i = 0; i < stringArrayOfBooks.length; i++) {
//            Item item = parseBookElements(stringArrayOfBooks[i], i);
//            items.add(item);
//        }
//        if(booksValidationService.getIncorrectLineNumbers().length() != 0)
//            throw new FormatIncorrectException(booksValidationService.getIncorrectLineNumbers());
//        return items;
//    }

//    private Item parseBookElements(String bookString, int index){
//        String[] bookElements = bookString.split("\\s*,\\s*");
//        booksValidationService.validate(bookElements, index);
//        int publishYear = Integer.parseInt(bookElements[3]);
//        int totalAvailability = Integer.parseInt(bookElements[5]);
//     //   Item item = new Item(UUID.randomUUID().toString(), bookElements[1],
//     //               bookElements[2], publishYear, bookElements[0], totalAvailability);
//     //   return item;
//    }
}
