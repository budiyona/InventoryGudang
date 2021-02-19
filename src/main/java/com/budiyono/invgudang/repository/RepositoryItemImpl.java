package com.budiyono.invgudang.repository;

import com.budiyono.invgudang.mapper.MapperItem;
import com.budiyono.invgudang.model.Item;
import com.budiyono.invgudang.model.ItemCategory;
import com.budiyono.invgudang.service.ServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("RepositoryItem")
public class RepositoryItemImpl implements RepositoryItem{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ServiceCategory serviceCategory;

    @Override
    public List<Item> findAllItem(String limit, String offset) {
        String query = "select * from item limit "+limit+" offset " + offset;
        List<MapperItem> mItems = jdbcTemplate.query(query,
                (rs, rowNum) ->
                        new MapperItem(
                                rs.getString("idItem"),
                                rs.getString("nameItem"),
                                rs.getString("idCategory")
                        )
        );
        List<Item> Items= new ArrayList<>();
        for(MapperItem map: mItems){
            Item item = new Item();
            item.setIdItem(map.getIdItem());
            item.setNameItem(map.getNamaItem());
            item.setItemCategory(serviceCategory.findById(map.getItemCategory()));
            Items.add(item);
        }
        return Items;
    }

    @Override
    public Item findById(String id) {
        try {
            String query = "select * from item where idItem=?";
            MapperItem Mitem =jdbcTemplate.queryForObject(query,
                    (rs, rowNum) ->
                            new MapperItem(
                                    rs.getString("idItem"),
                                    rs.getString("nameItem"),
                                    rs.getString("idCategory")
                            ), id
            );
            Item item = new Item();
            item.setIdItem(Mitem.getIdItem());
            item.setNameItem(Mitem.getNamaItem());
            item.setItemCategory(serviceCategory.findById(Mitem.getItemCategory()));
            return item;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Item findByName(String name) {
        try {
            String query = "select * from item where nameItem=?";
            MapperItem Mitem = jdbcTemplate.queryForObject(query,
                    (rs, rowNum) ->
                            new MapperItem(
                                    rs.getString("idItem"),
                                    rs.getString("nameItem"),
                                    rs.getString("idCategory")
                            ), name
            );
            Item item = new Item();
            item.setIdItem(Mitem.getIdItem());
            item.setNameItem(Mitem.getNamaItem());
            item.setItemCategory(serviceCategory.findById(Mitem.getItemCategory()));
            return item;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void saveItems(List<Item> items) {
        for(Item item: items){
            saveItem(item);
        }
    }

    @Override
    public void saveItem(Item item) {
        String id = UUID.randomUUID().toString();
        item.setIdItem(id);
        String query = "insert into item (idItem, nameItem, idCategory) values (?,?,?)";
        jdbcTemplate.update(query, item.getIdItem(), item.getNameItem(),item.getItemCategory().getIdCategory());
    }

    @Override
    public void deleteItem(String id) {
        String query = "delete from item where idItem=?";
        jdbcTemplate.update(query,id);
    }

    @Override
    public void updateItem(Item item) {
        String query = "update item set idItem=?, nameItem=?, idCategory=?";
        jdbcTemplate.update(query, item.getIdItem(), item.getNameItem(),item.getItemCategory().getIdCategory());
    }
}
