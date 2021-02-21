package com.budiyono.invgudang.model;

public class Item {
    private String idItem;
    private String nameItem;
    private ItemCategory itemCategory;
    private int stock;

    public Item(){

    }

    public Item(String nameItem, int stock) {
        this.nameItem = nameItem;
        this.stock = stock;
    }

    public Item(String idItem, String nameItem, int stock) {
        this.idItem = idItem;
        this.nameItem = nameItem;
        this.stock = stock;
    }

    public Item(String idItem, String nameItem, ItemCategory itemCategory, int stock) {
        this.idItem = idItem;
        this.nameItem = nameItem;
        this.itemCategory = itemCategory;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
