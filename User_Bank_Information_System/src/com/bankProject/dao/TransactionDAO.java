package com.bankProject.dao;

import com.bankProject.model.Transaction;

import java.util.List;

public interface TransactionDAO {
     void addTransaction(Transaction transaction, String email);
     void removeTransaction(Transaction transaction, String email);
    List<Transaction> getTransactionsByAccountId(int accountId);
    List<Transaction> getAllTransactions();


}

