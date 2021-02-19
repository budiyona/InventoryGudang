package com.budiyono.invgudang.service;

import com.budiyono.invgudang.model.Curier;
import com.budiyono.invgudang.model.ItemCategory;
import com.budiyono.invgudang.repository.RepositoryCurier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ServiceCurier")
public class ServiceCurierImpl implements ServiceCurier{
    @Autowired
    RepositoryCurier repositoryCurier;

    @Override
    public List<Curier> findAllCurier(String limit, String offset) {
        return repositoryCurier.findAllCurier(limit, offset);
    }

    @Override
    public Curier findById(String id) {
        return repositoryCurier.findById(id);
    }

    @Override
    public Curier findByUName(String name) {
        return repositoryCurier.findByUName(name);
    }

    @Override
    public void saveCurier(Curier curier) {
        repositoryCurier.saveCurier(curier);
    }

    @Override
    public void deleteCurier(String id) {
        repositoryCurier.deleteCurier(id);
    }

    @Override
    public void updateCurier(Curier curier) {
        repositoryCurier.updateCurier(curier);
    }
}
