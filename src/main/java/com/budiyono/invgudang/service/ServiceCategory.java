package com.budiyono.invgudang.service;

import com.budiyono.invgudang.model.Item;
import com.budiyono.invgudang.model.ItemCategory;

import java.util.List;

public interface ServiceCategory {
    /*
        ROE
    FindAllwithpaginationb()
    FindByID()
    FindByName()
    DeleteByIDe()
    UpdateByIDf()
    Insert*/

    List<ItemCategory> findAllItemCategory(String limit, String offset);
    ItemCategory findById(String id);
    ItemCategory findByName(String name);
    void saveItemCategories(List<ItemCategory> itemCategory);
    void saveItemCategory(ItemCategory itemCategory);
    void deleteItemById(String id);
    void deleteItemByName(String name);
    void updateItemCategory(ItemCategory itemCategory);
}
