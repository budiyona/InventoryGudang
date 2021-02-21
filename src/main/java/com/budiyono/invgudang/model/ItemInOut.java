package com.budiyono.invgudang.model;

import com.budiyono.invgudang.model.ItemCategory;

public class ItemInOut {
    private String idItem;
    private String nameItem;
    private ItemCategory itemCategory;
    private int qty;

    public ItemInOut() {
    }

    public ItemInOut(String idItem, String nameItem, ItemCategory itemCategory, int qty) {
        this.idItem = idItem;
        this.nameItem = nameItem;
        this.itemCategory = itemCategory;
        this.qty = qty;
    }

    public ItemInOut(String idItem, String nameItem, int qty) {
        this.idItem = idItem;
        this.nameItem = nameItem;
        this.qty = qty;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
