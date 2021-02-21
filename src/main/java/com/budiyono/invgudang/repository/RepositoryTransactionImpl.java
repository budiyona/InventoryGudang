package com.budiyono.invgudang.repository;

import com.budiyono.invgudang.mapper.MapperItem;
import com.budiyono.invgudang.model.ItemInOut;
import com.budiyono.invgudang.mapper.MapperTrx;
import com.budiyono.invgudang.model.Item;
import com.budiyono.invgudang.model.Transaction;
import com.budiyono.invgudang.service.ServiceCategory;
import com.budiyono.invgudang.service.ServiceCourier;
import com.budiyono.invgudang.service.ServiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("RepositoryTransaction")
public class RepositoryTransactionImpl implements RepositoryTransaction {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ServiceCourier serviceCourier;

    @Autowired
    ServiceItem serviceItem;

    @Autowired
    ServiceCategory serviceCategory;

    @Override
    public List<Transaction> findAllTransaction(String limit, String offset) {
        List<Transaction> transactions = new ArrayList<>();
        String query = "select * from transaction limit " + limit + " offset " + offset;
        List<MapperTrx> mapperTrxList = jdbcTemplate.query(query,
                (rs, rowNum) -> new MapperTrx(
                        rs.getString("idItemTrx"),
                        rs.getString("nameItemTrx"),
                        rs.getString("dateTimeCreated"),
                        rs.getString("idCourier"),
                        rs.getString("type")
                )
        );
        for (MapperTrx mapperTrx : mapperTrxList) {
            Transaction transaction = new Transaction();

            transaction.setIdItemTrx(mapperTrx.getIdItemTrx());
            transaction.setNameItemTrx(mapperTrx.getNameItemTrx());
            transaction.setDateTimeCreated(mapperTrx.getDateTimeCreated());
            transaction.setType(mapperTrx.getType());
            transaction.setCourier(serviceCourier.findById(mapperTrx.getIdCourier()));

            String queryItem = "select i.idItem, i.nameItem, i.idCategory, d.qty " +
                    "from detail_transaction d " +
                    "join item i ON i.idItem =d.idItem " +
                    "where idItemTrx =?";

            List<ItemInOut> items = jdbcTemplate.query(queryItem,
                    (rs, rowNum) -> new ItemInOut(
                            rs.getString("idItem"),
                            rs.getString("nameItem"),
                            serviceCategory.findById(rs.getString("idCategory")),
                            rs.getInt("qty")
                    ),mapperTrx.getIdItemTrx());
            //list barang in / out
            transaction.setItems(items);

            transactions.add(transaction);
        }
        return transactions;
    }

    @Override
    public Transaction findById(String id) {
        try {
            String query = "select * from transaction where idItemtrx=?";
            MapperTrx mapperTrx = jdbcTemplate.queryForObject(query,
                    (rs, rowNum) -> new MapperTrx(
                            rs.getString("idItemTrx"),
                            rs.getString("nameItemTrx"),
                            rs.getString("dateTimeCreated"),
                            rs.getString("idCourier"),
                            rs.getString("type")
                    ), id
            );
            Transaction transaction = new Transaction();

            transaction.setIdItemTrx(mapperTrx.getIdItemTrx());
            transaction.setNameItemTrx(mapperTrx.getNameItemTrx());
            transaction.setDateTimeCreated(mapperTrx.getDateTimeCreated());
            transaction.setType(mapperTrx.getType());
            transaction.setCourier(serviceCourier.findById(mapperTrx.getIdCourier()));

            String queryItem = "select i.idItem, i.nameItem, i.idCategory, d.qty " +
                    "from detail_transaction d " +
                    "join item i ON i.idItem =d.idItem " +
                    "where idTransaction =?";

            List<ItemInOut> items = jdbcTemplate.query(queryItem,
                    (rs, rowNum) -> new ItemInOut(
                            rs.getString("idItem"),
                            rs.getString("nameItem"),
                            serviceCategory.findById(rs.getString("idCategory")),
                            rs.getInt("qty")
                    ),mapperTrx.getIdItemTrx());
            //list barang in / out
            transaction.setItems(items);
            return transaction;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Transaction findByName(String name) {
        try {
            String query = "select * from transaction where nameItemTrx=?";
            MapperTrx mapperTrx = jdbcTemplate.queryForObject(query,
                    (rs, rowNum) -> new MapperTrx(
                            rs.getString("idItemTrx"),
                            rs.getString("nameItemTrx"),
                            rs.getString("dateTimeCreated"),
                            rs.getString("idCourier"),
                            rs.getString("type")
                    ), name
            );
            Transaction transaction = new Transaction();

            transaction.setIdItemTrx(mapperTrx.getIdItemTrx());
            transaction.setNameItemTrx(mapperTrx.getNameItemTrx());
            transaction.setDateTimeCreated(mapperTrx.getDateTimeCreated());
            transaction.setType(mapperTrx.getType());
            transaction.setCourier(serviceCourier.findById(mapperTrx.getIdCourier()));

            String queryItem = "select i.idItem, i.nameItem, i.idCategory, d.qty " +
                    "from detail_transaction d " +
                    "join item i ON i.idItem =d.idItem " +
                    "where idTransaction =?";

            List<ItemInOut> items = jdbcTemplate.query(queryItem,
                    (rs, rowNum) -> new ItemInOut(
                            rs.getString("idItem"),
                            rs.getString("nameItem"),
                            serviceCategory.findById(rs.getString("idCategory")),
                            rs.getInt("qty")
                    ),mapperTrx.getIdItemTrx());
            //list barang in / out
            transaction.setItems(items);

            return transaction;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        String idtrx=  UUID.randomUUID().toString();
        String idDetail = UUID.randomUUID().toString();
        transaction.setIdItemTrx(idtrx);
        String queryHeader = "insert into transaction (" +
                "idItemTrx," +
                "nameItemTrx," +
                "dateTimeCreated," +
                "idCourier," +
                "type) values(?,?,?,?,?)";
        jdbcTemplate.update(queryHeader,
                idtrx,
                transaction.getNameItemTrx(),
                transaction.getDateTimeCreated(),
                transaction.getCourier().getIdCourier(),
                transaction.getType());

        String queryDetail = "insert into detail_transaction (" +
                "idTransaction," +
                "idItemTrx," +
                "idItem," +
                "qty) values(?,?,?,?)";

        for(ItemInOut i: transaction.getItems()){
            jdbcTemplate.update(queryDetail,
                    idDetail,
                    idtrx,
                    i.getIdItem(),
                    i.getQty()
                    );
        }
    }

    @Override
    public void deleteTransaction(String id) {
        String queryDetail = "delete from detail_transaction where idItemTrx=?";
        jdbcTemplate.update(queryDetail,id);

        String queryHeader ="delete from transaction where idItemTrx=?";
        jdbcTemplate.update(queryHeader,id);
    }

    @Override
    public void updateTransaction(Transaction transaction) {

        List<String> idDetail = jdbcTemplate.query(
                "select * from detail_transaction where idItemTrx=?",
                (rs, rowNum) -> rs.getString(
                        "idTransaction"
                ),
                transaction.getIdItemTrx()
        );
        String id=idDetail.get(0);
        jdbcTemplate.update("delete from detail_transaction where idtransaction=?",
                id);
        String queryDetail = "insert into detail_transaction (" +
                "idTransaction," +
                "idItemTrx," +
                "idItem," +
                "qty) values(?,?,?,?)";

        for(ItemInOut i: transaction.getItems()){
            jdbcTemplate.update(queryDetail,
                    id,
                    transaction.getIdItemTrx(),
                    i.getIdItem(),
                    i.getQty()
            );
        }
    }

    @Override
    public String getPrefix(String type) {
        String query = "select count(*) from transaction where dateTimeCreated=curdate() AND type=?";
        int count = jdbcTemplate.queryForObject(query, Integer.class, type);
        String prefix = String.format("%03d", count+1);
        return prefix;
    }
}
