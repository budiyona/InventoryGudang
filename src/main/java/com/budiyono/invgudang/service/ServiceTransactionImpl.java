package com.budiyono.invgudang.service;

import com.budiyono.invgudang.model.Transaction;
import com.budiyono.invgudang.repository.RepositoryTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServiceTransaction")
public class ServiceTransactionImpl implements ServiceTransaction {

    @Autowired
    RepositoryTransaction repositoryTransaction;

    @Override
    public String getPrefix(String type) {
        return repositoryTransaction.getPrefix(type);
    }

    @Override
    public List<Transaction> findAllTransaction(String limit, String offset) {
        return repositoryTransaction.findAllTransaction(limit, offset);
    }

    @Override
    public Transaction findById(String id) {
        return repositoryTransaction.findById(id);
    }

    @Override
    public Transaction findByName(String name) {
        return repositoryTransaction.findByName(name);
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        repositoryTransaction.saveTransaction(transaction);
    }

    @Override
    public void deleteTransaction(String id) {
        repositoryTransaction.deleteTransaction(id);
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        repositoryTransaction.updateTransaction(transaction);
    }
}
