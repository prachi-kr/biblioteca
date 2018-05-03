package com.biblioteca.model;

import java.util.Objects;

public class Item {
    private String id;
    private String title;
    private int year;
    private int totalAvailability;
    private String type;
    private String details;

    public Item(String id, String title, int year, int totalAvailability, String type, String details) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.totalAvailability = totalAvailability;
        this.type = type;
        this.details = details;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", totalAvailability=" + totalAvailability +
                ", type='" + type + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    public Item() {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTotalAvailability() {
        return totalAvailability;
    }

    public void setTotalAvailability(int totalAvailability) {
        this.totalAvailability = totalAvailability;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return year == item.year &&
                totalAvailability == item.totalAvailability &&
                Objects.equals(id, item.id) &&
                Objects.equals(title, item.title) &&
                Objects.equals(type, item.type) &&
                Objects.equals(details, item.details);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, year, totalAvailability, type, details);
    }
}