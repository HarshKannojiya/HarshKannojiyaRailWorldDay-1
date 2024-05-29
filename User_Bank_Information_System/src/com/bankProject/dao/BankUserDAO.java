package com.bankProject.dao;

import com.bankProject.model.BankUser;
import com.bankProject.model.User;

import java.sql.SQLException;

public interface BankUserDAO {
    public void addBankUser(BankUser bu, User u) throws SQLException;
}
