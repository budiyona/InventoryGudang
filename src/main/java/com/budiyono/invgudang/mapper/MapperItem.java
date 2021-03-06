package com.budiyono.invgudang.mapper;

public class MapperItem {
    private String idItem;
    private String namaItem;
    private String itemCategory;
    private int stock;

    public MapperItem(String idItem, String namaItem, String itemCategory, int stock) {
        this.idItem = idItem;
        this.namaItem = namaItem;
        this.itemCategory = itemCategory;
        this.stock=stock;
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

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

