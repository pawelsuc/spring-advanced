package com.pawelsuc.service;

import com.pawelsuc.entity.Item;

import java.util.List;

public interface ItemService {
    public void saveItem(Item item);

    public List<Item> getItemsWithQuantityOverTwenty();


}
