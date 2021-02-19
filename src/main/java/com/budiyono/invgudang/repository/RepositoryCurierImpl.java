package com.budiyono.invgudang.repository;

import com.budiyono.invgudang.model.Curier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("RepositoryCurier")
public class RepositoryCurierImpl implements RepositoryCurier {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Curier> findAllCurier(String limit, String offset) {
        String query = "select * from curier limit " + limit + " offset " + offset;
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
        try {
            String query = "select * from curier where idCurier = ?";
            return jdbcTemplate.queryForObject(query,
                    (rs, rowNub) ->
                            new Curier(
                                    rs.getString("idCurier"),
                                    rs.getString("nameCurier"),
                                    rs.getString("usernameCurier"),
                                    rs.getString("idVehicle")
                            ), id
            );
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Curier findByUName(String uname) {
        try {
        String query = "select * from curier where usernameCurier = ?";
        return jdbcTemplate.queryForObject(query,
                (rs, rowNub) ->
                        new Curier(
                                rs.getString("idCurier"),
                                rs.getString("nameCurier"),
                                rs.getString("usernameCurier"),
                                rs.getString("idVehicle")
                        ), uname
        );
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void saveCurier(Curier curier) {
        curier.setIdCurier(UUID.randomUUID().toString());
        String query = "insert into curier (idCurier,nameCurier,usernameCurier,idVehicle) values(?,?,?,?)";
        jdbcTemplate.update(query,
                curier.getIdCurier(),
                curier.getNameCurier(),
                curier.getUsernameCurier(),
                curier.getIdVehicle()
        );

    }

    @Override
    public void deleteCurier(String id) {
        jdbcTemplate.update("delete from curier where idTipeKimia=?", id);
    }

    @Override
    public void updateCurier(Curier curier) {
        String query = "update curier set idCurier=? ,nameCurier=?,usernameCurier=?,idVehicle=?";
        jdbcTemplate.update(query,
                curier.getIdCurier(),
                curier.getNameCurier(),
                curier.getUsernameCurier(),
                curier.getIdCurier()
                );
    }
}
