package com.bankProject.dao;

import com.bankProject.model.BankAccount;

import java.util.List;

public interface BankAccountDAO {
    void addBankAccount(BankAccount bankAccount);
    BankAccount getBankAccountByUserId(int userId);
    List<BankAccount> getAllBankAccounts();
    void updateBankAccount(BankAccount bankAccount);
    void deleteBankAccount(int accountId);
}
