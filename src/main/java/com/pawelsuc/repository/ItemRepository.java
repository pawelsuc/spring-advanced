package com.pawelsuc.repository;

import com.pawelsuc.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository <Item, Long> {
}
