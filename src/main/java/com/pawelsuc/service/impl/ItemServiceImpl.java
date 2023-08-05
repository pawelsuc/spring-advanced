package com.pawelsuc.service.impl;

import com.pawelsuc.entity.Item;
import com.pawelsuc.repository.ItemRepository;
import com.pawelsuc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;


    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);

    }

    @Override
    public List<Item> getItemsWithQuantityOverTwenty() {
        return itemRepository.getItemsWithQuantityOverTwenty();
    }

    @Override
    public List<Item> getItemsWithQuantityOver(int minQuantityThreshold) {
        return itemRepository.getItemWithQuantityOver(minQuantityThreshold);
    }

    @Override
    public List<Item> getItemsWithNameLike(String regex) {
        return itemRepository.getItemsWithNameLike(regex);
    }

    @Override
    public List<Item> findByQuantity(Integer quantity) {
        return itemRepository.findByQuantity(quantity);
    }

    @Override
    public List<Item> findByQuantityBetween(Integer minQuantity, Integer maxQuantity) {
        return itemRepository.findByQuantityBetween(minQuantity,maxQuantity);
    }

    @Override
    public List<Item> findByQuantityGreaterThanEqualOrderByQuantityDesc(Integer minQuantity) {
        return itemRepository.findByQuantityGreaterThanEqualOrderByQuantityDesc(minQuantity);
    }
}
