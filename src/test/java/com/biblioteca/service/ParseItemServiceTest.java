package com.biblioteca.service;

import com.biblioteca.exception.FormatIncorrectException;
import com.biblioteca.model.Item;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ParseItemServiceTest {

//    @Test
//    public void shouldBeAbleToParseOneBooks() throws FormatIncorrectException {
//        ParseBookService parseBookService = new ParseBookService();
//        String oneBook = "200501844, Clara Callan, Richard Bruce Wright, 2001, 5";
//        List<Item> items = parseBookService.parseBooks(oneBook);
//        assertEquals(items, Arrays.asList(oneBook));
//    }
//
//    @Test
//    public void shouldBeAbleToParseManyBooks() throws FormatIncorrectException {
//        ParseBookService parseBookService = new ParseBookService();
//        String books = "200501844, Clara Callan, Richard Bruce Wright, 2001, 5" +
//                "200551844, Clara Callan, Richard Bruce Wright, 2001, 5" +
//                "200501844, Clara Callan, Richard Bruce Wright, 2001, 5" +
//                "200501844, Clara Callan, Richard Bruce Wright, 2001, 5";
//        List<Item> parsedbooks = parseBookService.parseBooks(books);
//
//        //assertEquals(books, Arrays.asList(OneBook));
//    }
}