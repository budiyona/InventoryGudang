package com.budiyono.invgudang.service;

import com.budiyono.invgudang.model.Item;

import java.util.List;

public interface ServiceItem {
    List<Item> findAllItem();
    Item findById(String id);
    Item findByName(String name);
    void saveItem(Item item);
    void saveMulItem(List<Item> items);
    void deleteItem(String id);
    void updateItem(Item item);
}
