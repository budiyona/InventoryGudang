package com.budiyono.invgudang.mapper;

public class MapperTrx {
    private String idItemTrx;
    private String nameItemTrx;
    private String dateTimeCreated;
    private String idCourier;
    private String type;

    public MapperTrx() {
    }

    public MapperTrx(String idItemTrx, String nameItemTrx, String dateTimeCreated, String idCourier, String type) {
        this.idItemTrx = idItemTrx;
        this.nameItemTrx = nameItemTrx;
        this.dateTimeCreated = dateTimeCreated;
        this.idCourier = idCourier;
        this.type = type;
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

    public String getIdCourier() {
        return idCourier;
    }

    public void setIdCourier(String idCourier) {
        this.idCourier = idCourier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MapperTrx{" +
                "idItemTrx='" + idItemTrx + '\'' +
                ", nameItemTrx='" + nameItemTrx + '\'' +
                ", dateTimeCreated='" + dateTimeCreated + '\'' +
                ", idCourier='" + idCourier + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
