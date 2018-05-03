package com.biblioteca.exception;

public class FormatIncorrectException extends Throwable {
    public FormatIncorrectException(StringBuilder str) {
        super("Line Numbers "+ str + " is/are not in correct format");
    }
}
