package com.budiyono.invgudang.service;

import com.budiyono.invgudang.model.Courier;
import com.budiyono.invgudang.repository.RepositoryCourier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ServiceCourier")
public class ServiceCourierImpl implements ServiceCourier {
    @Autowired
    RepositoryCourier repositoryCourier;

    @Override
    public List<Courier> findAllCourier(String limit, String offset) {
        return repositoryCourier.findAllCourier(limit, offset);
    }

    @Override
    public Courier findById(String id) {
        return repositoryCourier.findById(id);
    }

    @Override
    public Courier findByUName(String name) {
        return repositoryCourier.findByUName(name);
    }

    @Override
    public void saveCourier(Courier courier) {
        repositoryCourier.saveCourier(courier);
    }

    @Override
    public void deleteCourier(String id) {
        repositoryCourier.deleteCourier(id);
    }

    @Override
    public void updateCourier(Courier courier) {
        repositoryCourier.updateCourier(courier);
    }
}
