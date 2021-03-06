package com.budiyono.invgudang.repository;

import com.budiyono.invgudang.model.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("RepositoryItemCategory")
public class RepositoryItemCategoryImpl implements RepositoryItemCategory {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<ItemCategory> findAllItemCategory(String limit, String offset) {
        String query="";
        if(limit.equalsIgnoreCase("0")&&offset.equalsIgnoreCase("0")){
            query = "select * from item_category";
        }else {
            query = "select * from item_category limit " + limit + " offset " + offset;
        }
        return jdbcTemplate.query(query,
                (rs, rowNum) ->
                        new ItemCategory(
                                rs.getString("idCategory"),
                                rs.getString("nameCategory")
                        )

        );

    }

    @Override
    public ItemCategory findById(String id) {
        try {
            String query = "select * from item_category where idCategory=?";
            return jdbcTemplate.queryForObject(query,
                    (rs, rowNum) ->
                            new ItemCategory(
                                    rs.getString("idCategory"),
                                    rs.getString("nameCategory")
                            ), id
            );
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ItemCategory findByName(String name) {
        try {
            String query = "select * from item_category where nameCategory=?";
            return jdbcTemplate.queryForObject(query,
                    (rs, rowNum) ->
                            new ItemCategory(
                                    rs.getString("idCategory"),
                                    rs.getString("nameCategory")
                            ), name
            );
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void saveItemCategories(List<ItemCategory> itemCategories) {
        for (ItemCategory itemCategory: itemCategories) {
            saveItemCategory(itemCategory);
        }
    }

    @Override
    public void saveItemCategory(ItemCategory itemCategory) {
        String id = UUID.randomUUID().toString();
        itemCategory.setIdCategory(id);
        String query = "insert into item_category (idCategory, nameCategory) values (?,?)";
        jdbcTemplate.update(query, itemCategory.getIdCategory(), itemCategory.getNameCategory());
    }

    @Override
    public void deleteItemById(String id) {
        String query = "delete from item_category where idCategory=?";
        jdbcTemplate.update(query,id);
    }

    @Override
    public void deleteItemByName(String name) {
        String query = "delete from item_category where nameCategory=?";
        jdbcTemplate.update(query,name);
    }

    @Override
    public void updateItemCategory(ItemCategory itemCategory) {
        String query = "update item_category set nameCategory=? where idCategory=?";
        jdbcTemplate.update(query,itemCategory.getNameCategory(),itemCategory.getIdCategory());
    }
}
