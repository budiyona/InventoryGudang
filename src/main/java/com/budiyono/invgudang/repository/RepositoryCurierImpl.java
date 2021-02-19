package com.budiyono.invgudang.repository;

import com.budiyono.invgudang.model.Curier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RepositoryCurier")
public class RepositoryCurierImpl implements RepositoryCurier{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Curier> findAllCurier(String limit, String offset) {
        String query = "select * from curier limit "+limit+" offset "+offset;
        return jdbcTemplate.query(query,
                (rs, rowNub) ->
                        new Curier(
                                rs.getString("idCurier"),
                                rs.getString("nameCurier"),
                                rs.getString("usernameCurier"),
                                rs.getString("idVehicle")
                        )
        );
    }

    @Override
    public Curier findById(String id) {
        String query = "select * from curier limit where idCurier = ?";
        return jdbcTemplate.queryForObject(query,
                (rs, rowNub) ->
                        new Curier(
                                rs.getString("idCurier"),
                                rs.getString("nameCurier"),
                                rs.getString("usernameCurier"),
                                rs.getString("idVehicle")
                        ),id
        );
    }

    @Override
    public Curier findByUName(String name) {
        String query = "select * from curier limit where usernameCurier = ?";
        return jdbcTemplate.queryForObject(query,
                (rs, rowNub) ->
                        new Curier(
                                rs.getString("idCurier"),
                                rs.getString("nameCurier"),
                                rs.getString("usernameCurier"),
                                rs.getString("idVehicle")
                        ),name
        );
    }

    @Override
    public void saveCurier(Curier item) {

    }

    @Override
    public void deleteCurier(String id) {

    }

    @Override
    public void updateCurier(Curier item) {

    }
}
