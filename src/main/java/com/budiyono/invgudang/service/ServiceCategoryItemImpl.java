package com.budiyono.invgudang.service;

import com.budiyono.invgudang.model.Item;
import com.budiyono.invgudang.model.ItemCategory;
import com.budiyono.invgudang.repository.RepositoryItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServiceCategory")
public class ServiceCategoryItemImpl implements ServiceCategory {
    @Autowired
    RepositoryItemCategory repositoryItemCategory;

    @Override
    public List<ItemCategory> findAllItemCategory(String limit, String offset) {
        return repositoryItemCategory.findAllItemCategory(limit, offset);
    }

    @Override
    public ItemCategory findById(String id) {
        return repositoryItemCategory.findById(id);
    }

    @Override
    public ItemCategory findByName(String name) {
        return repositoryItemCategory.findByName(name);
    }

    @Override
    public void saveItemCategories(List<ItemCategory> itemCategory) {
        repositoryItemCategory.saveItemCategories(itemCategory);
    }

    @Override
    public void saveItemCategory(ItemCategory itemCategory) {
        repositoryItemCategory.saveItemCategory(itemCategory);
    }

    @Override
    public void deleteItemById(String id) {
        repositoryItemCategory.deleteItemById(id);
    }

    @Override
    public void deleteItemByName(String name) {
        repositoryItemCategory.deleteItemByName(name);
    }

    @Override
    public void updateItemCategory(ItemCategory itemCategory) {
        repositoryItemCategory.updateItemCategory(itemCategory);
    }
}
