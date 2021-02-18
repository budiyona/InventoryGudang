package com.budiyono.invgudang.model;

public class ItemCategory {
    private String idCategory;
    private String nameCateory;

    public ItemCategory() {

    }

    public ItemCategory(String nameCateory) {
        this.nameCateory = nameCateory;
    }

    public ItemCategory(String idCategory, String nameCateory) {
        this.idCategory = idCategory;
        this.nameCateory = nameCateory;
    }


    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCateory() {
        return nameCateory;
    }

    public void setNameCateory(String nameCateory) {
        this.nameCateory = nameCateory;
    }

    @Override
    public String toString() {
        return "ItemCategory{" +
                "idCategory='" + idCategory + '\'' +
                ", nameCateory='" + nameCateory + '\'' +
                '}';
    }
}
