package com.budiyono.invgudang.model;

public class Curier {
    private String idCurier;
    private String nameCurier;
    private String usernameCurier;
    private String idVehicle;

    public Curier() {
    }

    public Curier(String nameCurier, String usernameCurier, String idVehicle) {
        this.nameCurier = nameCurier;
        this.usernameCurier = usernameCurier;
        this.idVehicle = idVehicle;
    }

    public Curier(String idCurier, String nameCurier, String usernameCurier, String idVehicle) {
        this.idCurier = idCurier;
        this.nameCurier = nameCurier;
        this.usernameCurier = usernameCurier;
        this.idVehicle = idVehicle;
    }

    public String getIdCurier() {
        return idCurier;
    }

    public void setIdCurier(String idCurier) {
        this.idCurier = idCurier;
    }

    public String getNameCurier() {
        return nameCurier;
    }

    public void setNameCurier(String nameCurier) {
        this.nameCurier = nameCurier;
    }

    public String getUsernameCurier() {
        return usernameCurier;
    }

    public void setUsernameCurier(String usernameCurier) {
        this.usernameCurier = usernameCurier;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    @Override
    public String toString() {
        return "Curier{" +
                "idCurier='" + idCurier + '\'' +
                ", nameCurier='" + nameCurier + '\'' +
                ", usernameCurier='" + usernameCurier + '\'' +
                ", idVehicle='" + idVehicle + '\'' +
                '}';
    }
}
