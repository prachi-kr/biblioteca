package com.biblioteca.model;

public class Book {
    private String id;
    private String title;
    private String author;
    private int publishYear;
    private String isbn;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Book(String id, String title, String author, int publishYear, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.isbn = isbn;
    }
}