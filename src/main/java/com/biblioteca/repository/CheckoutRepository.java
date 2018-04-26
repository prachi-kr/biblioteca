package com.biblioteca.repository;

import com.biblioteca.model.Checkout;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CheckoutRepository {

    private final DSLContext dsl;

    public CheckoutRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public void checkoutBook(Checkout checkout) {
        dsl.insertInto(DSL.table("checkout"), DSL.field("book_id"))
                .values(checkout.getBookId())
                .execute();
    }

    public List<Checkout> getAllCheckouts() {
        return dsl.select()
                .from(DSL.table("checkout"))
                .fetchInto(Checkout.class);
    }

}
