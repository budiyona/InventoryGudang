package com.budiyono.invgudang.repository;

import com.budiyono.invgudang.model.Curier;

import java.util.List;

public interface RepositoryCurier {
    List<Curier> findAllCurier(String limit, String offset);
    Curier findById(String id);
    Curier findByUName(String name);
    void saveCurier(Curier item);
    void deleteCurier(String id);
    void updateCurier(Curier item);
}
