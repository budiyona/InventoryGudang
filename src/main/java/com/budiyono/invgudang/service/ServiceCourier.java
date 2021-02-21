package com.budiyono.invgudang.service;

import com.budiyono.invgudang.model.Courier;

import java.util.List;

public interface ServiceCourier {
    List<Courier> findAllCourier(String limit, String offset);
    Courier findById(String id);
    Courier findByUName(String name);
    void saveCourier(Courier courier);
    void deleteCourier(String id);
    void updateCourier(Courier courier);
}
