package com.bankProject.dao;

import com.bankProject.model.BankAccount;
import com.bankProject.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDAOImpl implements BankAccountDAO {
//    private static final String URL = "jdbc:mysql://localhost:3306/BankDB";
//    private static final String USER = "root";
//    private static final String PASSWORD = "password";
//
//    private Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }

    @Override
    public void addBankAccount(BankAccount bankAccount) {
        String query = "INSERT INTO bank_accounts (user_id, branch_name, IFSC_code) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, bankAccount.getUserId());
            pstmt.setString(2, bankAccount.getBranchName());
            pstmt.setString(3,bankAccount.getIfscCode()+0+bankAccount.getBranchName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BankAccount getBankAccountByUserId(int userId) {
        String query = "SELECT * FROM bank_accounts WHERE user_id = ?";
        BankAccount bankAccount = null;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bankAccount = new BankAccount();
                bankAccount.setAccountId(rs.getInt("account_id"));
                bankAccount.setUserId(rs.getInt("user_id"));
                bankAccount.setBranchName(rs.getString("branch_name"));
                bankAccount.setIfscCode(rs.getString("IFSC_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bankAccount;
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        String query = "SELECT * FROM bank_accounts";
        List<BankAccount> bankAccounts = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                BankAccount bankAccount = new BankAccount();
                bankAccount.setAccountId(rs.getInt("account_id"));
                bankAccount.setUserId(rs.getInt("user_id"));
                bankAccount.setBranchName(rs.getString("branch_name"));
                bankAccount.setIfscCode(rs.getString("IFSC_code"));
                bankAccounts.add(bankAccount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bankAccounts;
    }

    @Override
    public void updateBankAccount(BankAccount bankAccount) {
        String query = "UPDATE bank_accounts SET branch_name = ?, IFSC_code = ? WHERE account_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, bankAccount.getBranchName());
            pstmt.setString(2, bankAccount.getIfscCode());
            pstmt.setInt(3, bankAccount.getAccountId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBankAccount(int accountId) {
        String query = "DELETE FROM bank_accounts WHERE account_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, accountId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
