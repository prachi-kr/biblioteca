package com.biblioteca.model;

import java.sql.Timestamp;

public class Checkout {

    private int id;
    private String bookId;
    private Timestamp dateOfIssue;
    private Timestamp dateOfReturn;


    public Checkout(Book book) {
        this.bookId = book.getId();
    }

    public Checkout() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Timestamp getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Timestamp dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Timestamp getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Timestamp dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "id=" + id +
                ", bookId='" + bookId + '\'' +
                ", dateOfIssue=" + dateOfIssue +
                ", dateOfReturn=" + dateOfReturn +
                '}';
    }
}
