package com.budiyono.invgudang.repository;

import com.budiyono.invgudang.model.Courier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("RepositoryCourier")
public class RepositoryCourierImpl implements RepositoryCourier {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Courier> findAllCourier(String limit, String offset) {
        String query="";
        if(limit.equalsIgnoreCase("0")&&offset.equalsIgnoreCase("0")){
            query = "select * from courier";
        }else {
            query = "select * from courier limit " + limit + " offset " + offset;
        }
        return jdbcTemplate.query(query,
                (rs, rowNub) ->
                        new Courier(
                                rs.getString("idCourier"),
                                rs.getString("nameCourier"),
                                rs.getString("usernameCourier"),
                                rs.getString("idVehicle")
                        )
        );
    }

    @Override
    public Courier findById(String id) {
        try {
            String query = "select * from courier where idCourier = ?";
            return jdbcTemplate.queryForObject(query,
                    (rs, rowNub) ->
                            new Courier(
                                    rs.getString("idCourier"),
                                    rs.getString("nameCourier"),
                                    rs.getString("usernameCourier"),
                                    rs.getString("idVehicle")
                            ), id
            );
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Courier findByUName(String uname) {
        try {
        String query = "select * from courier where usernameCourier = ?";
        return jdbcTemplate.queryForObject(query,
                (rs, rowNub) ->
                        new Courier(
                                rs.getString("idCourier"),
                                rs.getString("nameCourier"),
                                rs.getString("usernameCourier"),
                                rs.getString("idVehicle")
                        ), uname
        );
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void saveCourier(Courier courier) {
        courier.setIdCourier(UUID.randomUUID().toString());
        String query = "insert into courier (idCourier,nameCourier,usernameCourier,idVehicle) values(?,?,?,?)";
        jdbcTemplate.update(query,
                courier.getIdCourier(),
                courier.getNameCourier(),
                courier.getUsernameCourier(),
                courier.getIdVehicle()
        );

    }

    @Override
    public void deleteCourier(String id) {
        jdbcTemplate.update("delete from courier where idCourier=?", id);
    }

    @Override
    public void updateCourier(Courier courier) {
        String query = "update courier set idCourier=? ,nameCourier=?,usernameCourier=?,idVehicle=?";
        jdbcTemplate.update(query,
                courier.getIdCourier(),
                courier.getNameCourier(),
                courier.getUsernameCourier(),
                courier.getIdCourier()
                );
    }
}
