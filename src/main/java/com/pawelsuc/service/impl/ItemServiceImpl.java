package com.pawelsuc.service.impl;

import com.pawelsuc.entity.Item;
import com.pawelsuc.repository.ItemRepository;
import com.pawelsuc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;


    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);

    }
}
