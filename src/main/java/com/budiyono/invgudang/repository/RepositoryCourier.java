package com.budiyono.invgudang.repository;

import com.budiyono.invgudang.model.Courier;

import java.util.List;

public interface RepositoryCourier {
    List<Courier> findAllCourier(String limit, String offset);
    Courier findById(String id);
    Courier findByUName(String name);
    void saveCourier(Courier item);
    void deleteCourier(String id);
    void updateCourier(Courier item);
}
