package com.budiyono.invgudang.repository;

import com.budiyono.invgudang.model.Transaction;

import java.util.List;

public interface RepositoryTransaction {
    List<Transaction> findAllTransaction(String limit, String offset);
    Transaction findById(String id);
    Transaction findByName(String name);
    void saveTransaction(Transaction transaction);
    void deleteTransaction(String id);
    void updateTransaction(Transaction transaction);
}
