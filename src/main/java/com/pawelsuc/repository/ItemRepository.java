package com.pawelsuc.repository;

import com.pawelsuc.entity.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query("select i from Item i where i.quantity>20")
    public List<Item> getItemsWithQuantityOverTwenty();
}
