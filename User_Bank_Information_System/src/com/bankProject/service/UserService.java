package com.bankProject.service;

import com.bankProject.dao.*;
import com.bankProject.model.*;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO;
    private BankUserDAO bankUserDAO;
    private BankAccountDAO bankAccountDAO;
    private TransactionDAO transactionDAO;
    private AdminDAO adminDAO;
    public UserService() {
        this.userDAO = new UserDAOImpl();
        this.bankUserDAO = new BankUserDAOImpl();
        this.adminDAO = new AdminDAOImpl();
        this.bankAccountDAO = new BankAccountDAOImpl();
        this.transactionDAO = new TransactionDAOImpl();
    }
    public boolean isAdmin(Admin admin){
        return adminDAO.isAdmin(admin);
    }
    public void addBankUser(BankUser bu, User u) throws SQLException {
        bankUserDAO.addBankUser(bu ,u);
    }

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public User getUserByAccountNumber(String accountNumber) {
        return userDAO.getUserByAccountNumber(accountNumber);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(String accountNumber) {
        userDAO.deleteUser(accountNumber);
    }

    public void addBankAccount(BankAccount bankAccount) {
        bankAccountDAO.addBankAccount(bankAccount);
    }

    public BankAccount getBankAccountByUserId(int userId) {
        return bankAccountDAO.getBankAccountByUserId(userId);
    }

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountDAO.getAllBankAccounts();
    }

    public void updateBankAccount(BankAccount bankAccount) {
        bankAccountDAO.updateBankAccount(bankAccount);
    }

    public void deleteBankAccount(int accountId) {
        bankAccountDAO.deleteBankAccount(accountId);
    }

    public void addTransaction(Transaction transaction, String email) {
        transactionDAO.addTransaction(transaction,email);
    }

    public void removeTransaction(Transaction transaction, String email) {
        transactionDAO.removeTransaction(transaction,email);
    }



    public List<Transaction> getTransactionsByAccountId(int accountId) {
        return transactionDAO.getTransactionsByAccountId(accountId);
    }

    public List<Transaction> getAllTransactions() {
        return transactionDAO.getAllTransactions();
    }
}
