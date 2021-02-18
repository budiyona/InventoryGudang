package com.budiyono.invgudang.service;

import com.budiyono.invgudang.model.ItemCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServiceCategory")
public class ServiceCategoryItemImpl implements ServiceCategory{

    @Override
    public List<ItemCategory> findAllItemCategory() {
        return null;
    }

    @Override
    public ItemCategory findById(String id) {
        return null;
    }

    @Override
    public ItemCategory findByName(String name) {
        return null;
    }

    @Override
    public void saveItemCategory(ItemCategory itemCategory) {

    }

    @Override
    public void saveMulItemCategory(List<ItemCategory> itemCategories) {

    }

    @Override
    public void deleteItem(String id) {

    }

    @Override
    public void updateItemCategory(ItemCategory itemCategory) {

    }
}
