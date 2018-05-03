package com.biblioteca.repository;

import com.biblioteca.model.Item;
import org.jooq.BatchBindStep;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class ItemRepository {

    private final DSLContext dsl;

    @Autowired
    public ItemRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<Item> getAllItems(String itemType) {
        return dsl.select()
                .from(DSL.table("item"))
                .where(DSL.field("type").eq(itemType))
                .fetchInto(Item.class);
    }

    public Item getItem(String itemId) {
        Record record =  dsl.select(DSL.field("id"), DSL.field("title"), DSL.field("year"), DSL.field("total_availability"), DSL.field("type"),DSL.field("details"))
                .from(DSL.table("item"))
                .where(DSL.field("id").eq(itemId))
                .fetchOne();
        return record == null? null : record.into(Item.class);
    }

//    public void insertOneOrManyBooks(List<Item> items) {
//        BatchBindStep batch = dsl.batch(dsl
//                .insertInto(DSL.table("item"),DSL.field("id"), DSL.field("title"), DSL.field("year"), DSL.field("totalAvailability"), DSL.field("type"),DSL.field("details"))
//                .values(null, null, null, null, null, null));
//        for (Item item : items) {
//            batch.bind(item.getId(), item.getTitle(), item.getYear(), item.getTotalAvailability(), item.getType(), item.getDetails());
//        }
//        batch.execute();
//    }
}