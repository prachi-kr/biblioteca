package com.biblioteca.model;

import java.sql.Timestamp;

public class Checkout {

    private String id;
    private String itemId;
    private Timestamp dateOfIssue;
    private Timestamp dateOfReturn;


    public Checkout(Item item) {
        this.itemId = item.getId();
    }

    public Checkout() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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
                ", itemId='" + itemId + '\'' +
                ", dateOfIssue=" + dateOfIssue +
                ", dateOfReturn=" + dateOfReturn +
                '}';
    }
}
