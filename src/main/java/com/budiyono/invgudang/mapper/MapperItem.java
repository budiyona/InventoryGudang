package com.budiyono.invgudang.mapper;

public class MapperItem {
    private String idCategory;
    private String nameCateory;

    public MapperItem() {}

    public MapperItem(String idCategory, String nameCateory) {
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
        return "MapperItem{" +
                "idCategory='" + idCategory + '\'' +
                ", nameCateory='" + nameCateory + '\'' +
                '}';
    }
}

