package com.budiyono.invgudang.service;

import com.budiyono.invgudang.model.Curier;

import java.util.List;

public interface ServiceCurier {
    List<Curier> findAllCurier(String limit, String offset);
    Curier findById(String id);
    Curier findByUName(String name);
    void saveCurier(Curier curier);
    void deleteCurier(String id);
    void updateCurier(Curier curier);
}
