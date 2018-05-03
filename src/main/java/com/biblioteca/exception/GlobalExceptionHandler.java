package com.biblioteca.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(ItemOutOfStockException.class)
    public ResponseEntity<Errors> handleBookOutOfStockException(Exception e) {
        LOGGER.warn(e.getMessage());
        return new ResponseEntity<>(Errors.bookOutOfStock(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidItemException.class)
    public ResponseEntity<Errors> handleInvalidItemException(Exception e) {
        LOGGER.warn(e.getMessage());
        return new ResponseEntity<>(Errors.bookIDNotValid(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidReturnException.class)
    public ResponseEntity<Errors> handleInvalidReturnException(Exception e) {
        LOGGER.warn(e.getMessage());
        return new ResponseEntity<>(Errors.returnNotValid(), HttpStatus.UNPROCESSABLE_ENTITY);
    }


}