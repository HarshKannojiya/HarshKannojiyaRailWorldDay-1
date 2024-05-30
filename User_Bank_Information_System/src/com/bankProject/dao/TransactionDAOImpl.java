package com.bankProject.dao;

import com.bankProject.model.Transaction;
import com.bankProject.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.bankProject.util.DBUtil.getConnection;

public class TransactionDAOImpl implements TransactionDAO {
//    private static final String URL = "jdbc:mysql://localhost:3306/BankDB";
//    private static final String USER = "root";
//    private static final String PASSWORD = "password";
//
//    private Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }

    @Override
    public void addTransaction(Transaction transaction, String email) {
        String query = "INSERT INTO transactions (account_id, transaction_amount) VALUES (?, ?)";
        String query1 = "SELECT balance FROM users WHERE email = '"+email+"'";
        String query2 = "UPDATE users SET balance =? WHERE email=?";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query1);

             PreparedStatement pstmt = conn.prepareStatement(query);
             PreparedStatement pstmt1 = conn.prepareStatement(query2)) {
            Double bal = 0.0;
            while (rs.next()){
                bal = rs.getDouble("balance");
            }
            System.out.println(bal);
            pstmt1.setDouble(1,bal+transaction.getTransactionAmount());
            pstmt1.setString(2,email);
            pstmt1.executeUpdate();
            pstmt.setInt(1, transaction.getAccountId());
            pstmt.setDouble(2, transaction.getTransactionAmount());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeTransaction(Transaction transaction, String email) {
        String query = "INSERT INTO transactions (account_id, transaction_amount) VALUES (?, ?)";
        String query1 = "SELECT balance FROM users WHERE email = '"+email+"'";
        String query2 = "UPDATE users SET balance =? WHERE email=?";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query1);
             PreparedStatement pstmt = conn.prepareStatement(query);
             PreparedStatement pstmt1 = conn.prepareStatement(query2)) {
            Double bal = 0.0;
            while (rs.next()){
                bal = rs.getDouble("balance");
            }
            System.out.println(bal);
            pstmt1.setDouble(1,bal-transaction.getTransactionAmount());
            pstmt1.setString(2,email);
            pstmt1.executeUpdate();
            pstmt.setInt(1, transaction.getAccountId());
            pstmt.setDouble(2, transaction.getTransactionAmount());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public List<Transaction> getTransactionsByAccountId(int accountId) {
        String query = "SELECT * FROM transactions WHERE account_id = ?";

        List<Transaction> transactions = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, accountId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(rs.getInt("transaction_id"));
                transaction.setAccountId(rs.getInt("account_id"));
                transaction.setTransactionAmount(rs.getDouble("transaction_amount"));
                transaction.setTransactionDate(rs.getTimestamp("transaction_date"));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        String query = "SELECT * FROM transactions";
        List<Transaction> transactions = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(rs.getInt("transaction_id"));
                transaction.setAccountId(rs.getInt("account_id"));
                transaction.setTransactionAmount(rs.getDouble("transaction_amount"));
                transaction.setTransactionDate(rs.getTimestamp("transaction_date"));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}

