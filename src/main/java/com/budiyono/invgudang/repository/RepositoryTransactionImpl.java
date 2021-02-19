package com.budiyono.invgudang.repository;

import com.budiyono.invgudang.mapper.MapperItem;
import com.budiyono.invgudang.mapper.MapperTrx;
import com.budiyono.invgudang.model.Curier;
import com.budiyono.invgudang.model.Item;
import com.budiyono.invgudang.model.Transaction;
import com.budiyono.invgudang.service.ServiceCurier;
import com.budiyono.invgudang.service.ServiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("RepositoryTransaction")
public class RepositoryTransactionImpl implements RepositoryTransaction {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ServiceCurier serviceCurier;

    @Autowired
    ServiceItem serviceItem;

    @Override
    public List<Transaction> findAllTransaction(String limit, String offset) {
        List<Transaction> transactions= new ArrayList<>();
        String query = "select * from transaction limit " + limit + " offset " + offset;
        List<MapperTrx> mapperTrxList = jdbcTemplate.query(query,
                (rs, rowNum) -> new MapperTrx(
                        rs.getString("idItemTrx"),
                        rs.getString("nameItemTrx"),
                        rs.getString("dateTimeCreated"),
                        rs.getString("idCurier"),
                        rs.getString("type")
                )
        );
        for (MapperTrx mapperTrx : mapperTrxList) {
            Transaction transaction = new Transaction();

            transaction.setIdItemTrx(mapperTrx.getIdItemTrx());
            transaction.setNameItemTrx(mapperTrx.getNameItemTrx());
            transaction.setDateTimeCreated(mapperTrx.getDateTimeCreated());
            transaction.setType(mapperTrx.getType());
            transaction.setCourier(serviceCurier.findById(mapperTrx.getIdCurier()));

            String queryItem = "select * from detail_transaction where idItemTrx=?";
            List<String> listIdItem = jdbcTemplate.query(queryItem, (rs, rowNum) -> rs.getString("idItem"),
                    mapperTrx.getIdItemTrx());
            List<Item> items = new ArrayList<>();

            for (String id : listIdItem) {
                Item item = serviceItem.findById(id);
                items.add(item);
            }
            transaction.setItems(items);

            transactions.add(transaction);
        }
        return transactions;
    }

    @Override
    public Transaction findById(String id) {
        return null;
    }

    @Override
    public Transaction findByName(String name) {
        return null;
    }

    @Override
    public void saveTransaction(Transaction transaction) {

    }

    @Override
    public void deleteTransaction(String id) {

    }

    @Override
    public void updateTransaction(Transaction transaction) {

    }
}
