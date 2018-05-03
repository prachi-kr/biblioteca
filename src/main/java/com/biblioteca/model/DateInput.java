package com.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class DateInput {

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date date;

    public DateInput() {
    }

    public DateInput(Date date) {

        this.date = date;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
