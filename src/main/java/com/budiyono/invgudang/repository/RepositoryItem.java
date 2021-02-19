package com.budiyono.invgudang.repository;

import com.budiyono.invgudang.model.Item;

import java.util.List;

public interface RepositoryItem {
    List<Item> findAllItem(String limit, String offset);
    Item findById(String id);
    Item findByName(String name);
    void saveItem(Item item);
    void saveItems(List<Item> items);
    void deleteItem(String id);
    void updateItem(Item item);
}
