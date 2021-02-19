package com.budiyono.invgudang.model;

public class Item {
    private String idItem;
    private String namaItem;
    private ItemCategory itemCategory;

    public Item(){

    }

    public Item(String namaItem, ItemCategory itemCategory) {
        this.namaItem = namaItem;
        this.itemCategory = itemCategory;
    }

    public Item(String idItem, String namaItem) {
        this.idItem = idItem;
        this.namaItem = namaItem;
    }

    public Item(String idItem, String namaItem, ItemCategory itemCategory) {
        this.idItem = idItem;
        this.namaItem = namaItem;
        this.itemCategory = itemCategory;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getNamaItem() {
        return namaItem;
    }

    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
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
                ", namaItem='" + namaItem + '\'' +
                ", itemCategory=" + itemCategory +
                '}';
    }
}
