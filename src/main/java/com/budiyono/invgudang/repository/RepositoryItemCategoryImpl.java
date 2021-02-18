package com.budiyono.invgudang.repository;

import com.budiyono.invgudang.model.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RepositoryItemCategory")
public class RepositoryItemCategoryImpl implements RepositoryItemCategory {

    @Autowired
    JdbcTemplate jdbcTemplate;

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
