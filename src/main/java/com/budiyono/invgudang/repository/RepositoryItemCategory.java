package com.budiyono.invgudang.repository;

import com.budiyono.invgudang.model.ItemCategory;

import java.util.List;

public interface RepositoryItemCategory {
    List<ItemCategory> findAllItemCategory(String limit, String offset);
    ItemCategory findById(String id);
    ItemCategory findByName(String name);
    void saveItemCategory(ItemCategory itemCategory);
    void saveItemCategories(List<ItemCategory> itemCategories);
    void deleteItemById(String id);
    void deleteItemByName(String name);
    void updateItemCategory(ItemCategory itemCategory);
}
