package com.budiyono.invgudang.repository;

import com.budiyono.invgudang.model.ItemCategory;

import java.util.List;

public interface RepositoryItemCategory {
    List<ItemCategory> findAllItemCategory();
    ItemCategory findById(String id);
    ItemCategory findByName(String name);
    void saveItemCategory(ItemCategory itemCategory);
    void saveMulItemCategory(List<ItemCategory> itemCategories);
    void deleteItem(String id);
    void updateItemCategory(ItemCategory itemCategory);
}
