package com.biblioteca.service;

public class BooksValidationService {

    private StringBuilder incorrectLineNumbers;

    public BooksValidationService() {
        incorrectLineNumbers = new StringBuilder();
    }

    public StringBuilder getIncorrectLineNumbers() {
        return incorrectLineNumbers;
    }

    public void validate(String[] bookElements, int index){
        validateISBN(bookElements[0], index);
        validatePublishYear(bookElements[3], index);
        validateTotalAvailability(bookElements[5], index);
    }
    private void validateISBN(String isbn, int index){
        if(isbn.length()<7)
           // throw new FormatIncorrectException( "ISBN" , index);
            incorrectLineNumbers.append(index);
    }
    private void validatePublishYear(String publishYear, int index){
        if(publishYear.length()!=4 )
            //throw new FormatIncorrectException( "Publish Year" , index);
            incorrectLineNumbers.append(index);
    }
    private void validateTotalAvailability(String totalAvailability, int index){
            //throw new FormatIncorrectException( "Publish Year" , index);
        incorrectLineNumbers.append(index);
    }
}
