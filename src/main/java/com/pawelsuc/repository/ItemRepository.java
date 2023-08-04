package com.pawelsuc.repository;

import com.pawelsuc.entity.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query("select i from Item i where i.quantity>20")
    public List<Item> getItemsWithQuantityOverTwenty();

    @Query("select i from Item i where i.quantity>:minQuantityThreshold")
    public List<Item> getItemWithQuantityOver(@Param("minQuantityThreshold") int minQuantityThreshold);

    @Query("select i from Item i where i.name like :regex")
    public List<Item> getItemsWithNameLike(@Param("regex") String regex);
}
