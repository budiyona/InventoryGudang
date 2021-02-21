package com.budiyono.invgudang.model;

public class Courier {
    private String idCourier;
    private String nameCourier;
    private String usernameCourier;
    private String idVehicle;

    public Courier() {
    }

    public Courier(String nameCourier, String usernameCourier, String idVehicle) {
        this.nameCourier = nameCourier;
        this.usernameCourier = usernameCourier;
        this.idVehicle = idVehicle;
    }

    public Courier(String idCourier, String nameCourier, String usernameCourier, String idVehicle) {
        this.idCourier = idCourier;
        this.nameCourier = nameCourier;
        this.usernameCourier = usernameCourier;
        this.idVehicle = idVehicle;
    }

    public String getIdCourier() {
        return idCourier;
    }

    public void setIdCourier(String idCourier) {
        this.idCourier = idCourier;
    }

    public String getNameCourier() {
        return nameCourier;
    }

    public void setNameCourier(String nameCourier) {
        this.nameCourier = nameCourier;
    }

    public String getUsernameCourier() {
        return usernameCourier;
    }

    public void setUsernameCourier(String usernameCourier) {
        this.usernameCourier = usernameCourier;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "idCourier='" + idCourier + '\'' +
                ", nameCourier='" + nameCourier + '\'' +
                ", usernameCourier='" + usernameCourier + '\'' +
                ", idVehicle='" + idVehicle + '\'' +
                '}';
    }
}
