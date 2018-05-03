package com.biblioteca.repository;

import com.biblioteca.model.Item;
import com.biblioteca.model.Checkout;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class CheckoutRepository {

    private final DSLContext dsl;

    public CheckoutRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public Checkout checkoutItem(Checkout checkout) {
        String uuid= String.valueOf(UUID.randomUUID());
        dsl.insertInto(DSL.table("checkout"), DSL.field("id"), DSL.field("item_id"))
                .values(uuid,checkout.getItemId())
                .execute();
        checkout.setId(uuid);
        return checkout;
    }

    public List<Checkout> getAllCheckouts() {
        return dsl.select()
                .from(DSL.table("checkout"))
                .fetchInto(Checkout.class);
    }

    public int getTotalCheckoutsForItem(Item item) {
        return dsl.select()
                .from(DSL.table("checkout"))
                .where(DSL.field("item_id").eq(item.getId()))
                .fetchInto(Checkout.class).size();
    }

    public Checkout updateDateOfReturnforItem(Checkout checkout, Date date) {
        dsl.update(DSL.table("checkout"))
                    .set(DSL.field("date_of_return"), date)
                    .where(DSL.field("id").eq(checkout.getId())).execute();
        return dsl.select(DSL.field("id"),DSL.field("item_id"), DSL.field("date_of_isse"), DSL.field("date_of_return"))
                .from(DSL.table("checkout"))
                .where(DSL.field("id").eq(checkout.getId()))
                .fetchOne()
                .into(Checkout.class);
        }

    public Checkout getCheckout(String checkoutId) {
        Record record = dsl.select(DSL.field("id"),DSL.field("item_id"), DSL.field("date_of_isse"), DSL.field("date_of_return"))
                .from(DSL.table("checkout"))
                .where(DSL.field("id").eq(checkoutId))
                .fetchOne();
        return record == null ? null : record.into(Checkout.class);
        }
}