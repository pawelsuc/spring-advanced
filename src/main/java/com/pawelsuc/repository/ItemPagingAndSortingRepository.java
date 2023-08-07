package com.pawelsuc.repository;

import com.pawelsuc.entity.Item;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemPagingAndSortingRepository extends PagingAndSortingRepository<Item, Long> {
}
