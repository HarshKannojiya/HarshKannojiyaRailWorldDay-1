package com.bankProject.dao;

import com.bankProject.model.Transaction;

import java.util.List;

public interface TransactionDAO {
    void addTransaction(Transaction transaction);
    List<Transaction> getTransactionsByAccountId(int accountId);
    List<Transaction> getAllTransactions();
}

