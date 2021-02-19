package com.budiyono.invgudang.mapper;

public class MapperTrx {
    private String idItemTrx;
    private String nameItemTrx;
    private String dateTimeCreated;
    private String idCurier;
    private String type;

    public MapperTrx() {
    }

    public MapperTrx(String idItemTrx, String nameItemTrx, String dateTimeCreated, String idCurier, String type) {
        this.idItemTrx = idItemTrx;
        this.nameItemTrx = nameItemTrx;
        this.dateTimeCreated = dateTimeCreated;
        this.idCurier = idCurier;
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

    public String getIdCurier() {
        return idCurier;
    }

    public void setIdCurier(String idCurier) {
        this.idCurier = idCurier;
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
                ", idCurier='" + idCurier + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
