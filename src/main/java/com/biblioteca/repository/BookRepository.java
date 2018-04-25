package com.biblioteca.repository;

import com.biblioteca.model.Book;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class BookRepository {

    private final DSLContext dsl;

    @Autowired
    public BookRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<Book> getAllBooks() {
        return dsl.select()
                .from(DSL.table("BOOK"))
                .fetchInto(Book.class);
    }
}
