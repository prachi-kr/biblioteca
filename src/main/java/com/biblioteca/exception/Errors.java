package com.biblioteca.exception;

import java.util.*;

public class Errors {

    private List<ApplicationError> errors;

    public Errors() {
        this.errors = new ArrayList<>();
    }

    public List<ApplicationError> getErrors() {
        return errors;
    }

    public Errors(List<ApplicationError> errors) {

        this.errors = errors;
    }

    public static Errors endPointNotFound() {
        return new Errors(Collections.singletonList(new ApplicationError(UUID.randomUUID().toString(), "404", "ENDPOINT_NOT_FOUND")));
    }

    public static Errors bookIDNotValid() {
        return new Errors(Collections.singletonList(new ApplicationError(UUID.randomUUID().toString(), "404", "BOOK_NOT_VALID")));
    }

    public static Errors bookOutOfStock() {
        return new Errors(Collections.singletonList(new ApplicationError(UUID.randomUUID().toString(), "422", "BOOK_OUT_OF_STOCK")));
    }

    public static Errors returnNotValid() {
        return new Errors(Collections.singletonList(new ApplicationError(UUID.randomUUID().toString(), "404", "CHECKOUT_RETURN_NOT_VALID")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Errors errors1 = (Errors) o;
        return Objects.equals(errors, errors1.errors);
    }

    @Override
    public int hashCode() {

        return Objects.hash(errors);
    }
}
