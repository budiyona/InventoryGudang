package com.budiyono.invgudang.model;

public class Item {
    private String idItem;
    private String nameItem;
    private ItemCategory itemCategory;

    public Item(){

    }

    public Item(String nameItem, ItemCategory itemCategory) {
        this.nameItem = nameItem;
        this.itemCategory = itemCategory;
    }

    public Item(String idItem, String nameItem) {
        this.idItem = idItem;
        this.nameItem = nameItem;
    }

    public Item(String idItem, String nameItem, ItemCategory itemCategory) {
        this.idItem = idItem;
        this.nameItem = nameItem;
        this.itemCategory = itemCategory;
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

    @Override
    public String toString() {
        return "Item{" +
                "idItem='" + idItem + '\'' +
                ", nameItem='" + nameItem + '\'' +
                ", itemCategory=" + itemCategory +
                '}';
    }
}
