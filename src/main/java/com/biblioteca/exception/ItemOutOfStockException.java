package com.biblioteca.exception;

public class ItemOutOfStockException extends RuntimeException{

    public ItemOutOfStockException() {
        super("This book is currently out of stock");
    }

}
