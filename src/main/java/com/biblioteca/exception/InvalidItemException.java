package com.biblioteca.exception;

public class InvalidItemException extends RuntimeException {

    public InvalidItemException(String bookId) {
        super("Item id - " + bookId + ", is an invalid BookId");
    }

}
