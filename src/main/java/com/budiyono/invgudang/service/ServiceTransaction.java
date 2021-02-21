package com.budiyono.invgudang.service;

import com.budiyono.invgudang.model.Transaction;

import java.util.List;

public interface ServiceTransaction {
    List<Transaction> findAllTransaction(String limit, String offset);
    Transaction findById(String id);
    Transaction findByName(String name);
    void saveTransaction(Transaction transaction);
    void deleteTransaction(String id);
    void updateTransaction(Transaction transaction);
    String getPrefix(String type);
}