package com.budiyono.invgudang.service;

import com.budiyono.invgudang.model.Item;

import java.util.List;

public interface ServiceItem {
    List<Item> findAllItem(String limit, String offset);
    Item findById(String id);
    Item findByName(String name);
    void saveItems(List<Item> items);
    void saveItem(Item item);
    void deleteItem(String id);
    void updateItem(Item item);
}
