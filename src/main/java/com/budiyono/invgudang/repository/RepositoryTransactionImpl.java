package com.budiyono.invgudang.repository;

import com.budiyono.invgudang.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RepositoryTransaction")
public class RepositoryTransactionImpl implements RepositoryTransaction{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Transaction> findAllTransaction(String limit, String offset) {
        return null;
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
