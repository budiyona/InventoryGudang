package com.budiyono.invgudang.model;

public class ItemCategory {
    private String idCategory;
    private String nameCategory;

    public ItemCategory() {

    }

    public ItemCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public ItemCategory(String idCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }


    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public String toString() {
        return "ItemCategory{" +
                "idCategory='" + idCategory + '\'' +
                ", nameCategory='" + nameCategory + '\'' +
                '}';
    }
}
