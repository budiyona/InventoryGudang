package com.budiyono.invgudang.service;

import com.budiyono.invgudang.model.Item;
import com.budiyono.invgudang.repository.RepositoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServiceItem")
public class ServiceItemImpl implements ServiceItem{

    @Autowired
    RepositoryItem repositoryItem;

    @Override
    public List<Item> findAllItem(String limit, String offset) {
        return repositoryItem.findAllItem(limit,offset);
    }

    @Override
    public Item findById(String id) {
        return repositoryItem.findById(id);
    }

    @Override
    public Item findByName(String name) {
        return repositoryItem.findByName(name);
    }

    @Override
    public void saveItem(Item item) {
        repositoryItem.saveItem(item);
    }

    @Override
    public void saveItems(List<Item> items) {
        repositoryItem.saveItems(items);
    }

    @Override
    public void deleteItem(String id) {
        repositoryItem.deleteItem(id);
    }

    @Override
    public void updateItem(Item item) {
        repositoryItem.updateItem(item);
    }
}
