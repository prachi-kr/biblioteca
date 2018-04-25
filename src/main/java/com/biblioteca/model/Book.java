package com.biblioteca.model;

public class Book {
    private String Id;
    private String Title;

    public Book(String id, String title) {
        Id = id;
        Title = title;
    }

    public String getId() {
        return Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id='" + Id + '\'' +
                ", Title='" + Title + '\'' +
                '}';
    }
}