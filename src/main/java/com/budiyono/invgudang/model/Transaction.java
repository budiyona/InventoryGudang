package com.budiyono.invgudang.model;

import java.util.List;

public class Transaction {
    private String idItemTrx;
    private String nameItemTrx;
    private String dateTimeCreated;
    private Courier courier;
    private String type;
    private List<ItemInOut> items;

    public Transaction() {
    }

    public Transaction(String nameItemTrx, String dateTimeCreated, String type) {
        this.nameItemTrx = nameItemTrx;
        this.dateTimeCreated = dateTimeCreated;
        this.type = type;
    }

    public Transaction(String idItemTrx, String nameItemTrx, String dateTimeCreated, String type) {
        this.idItemTrx = idItemTrx;
        this.nameItemTrx = nameItemTrx;
        this.dateTimeCreated = dateTimeCreated;
        this.type = type;
    }

    public Transaction(String idItemTrx, String nameItemTrx, String dateTimeCreated, Courier courier, String type, List<ItemInOut> items) {
        this.idItemTrx = idItemTrx;
        this.nameItemTrx = nameItemTrx;
        this.dateTimeCreated = dateTimeCreated;
        this.courier = courier;
        this.type = type;
        this.items = items;
    }

    public String getIdItemTrx() {
        return idItemTrx;
    }

    public void setIdItemTrx(String idItemTrx) {
        this.idItemTrx = idItemTrx;
    }

    public String getNameItemTrx() {
        return nameItemTrx;
    }

    public void setNameItemTrx(String nameItemTrx) {
        this.nameItemTrx = nameItemTrx;
    }

    public String getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(String dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ItemInOut> getItems() {
        return items;
    }

    public void setItems(List<ItemInOut> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "idItemTrx='" + idItemTrx + '\'' +
                ", nameItemTrx='" + nameItemTrx + '\'' +
                ", dateTimeCreated='" + dateTimeCreated + '\'' +
                ", courier=" + courier +
                ", type='" + type + '\'' +
                ", items=" + items +
                '}';
    }
}
