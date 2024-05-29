package com.bankProject.dao;

import com.bankProject.model.User;
import com.bankProject.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.bankProject.util.DBUtil.getConnection;

public class UserDAOImpl implements UserDAO {
//    private static final String URL = "jdbc:mysql://localhost:3306/BankDB";
//    private static final String USER = "root";
//    private static final String PASSWORD = "password";
//
//    private Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }

    @Override
    public void addUser(User user) {
        String query = "INSERT INTO users (name, accountNumber, balance) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getAccountNumber());
            pstmt.setDouble(3, user.getBalance());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByAccountNumber(String accountNumber) {
        String query = "SELECT * FROM users WHERE email = ?";
        User user = null;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAccountNumber(rs.getString("accountNumber"));
                user.setBalance(rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        String query = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
//                user.setAccountNumber(rs.getString("accountNumber"));
                user.setBalance(rs.getDouble("balance"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUser(User user) {
        String query = "UPDATE users SET name = ?, balance = ? WHERE accountNumber = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, user.getName());
            pstmt.setDouble(2, user.getBalance());
            pstmt.setString(3, user.getAccountNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String accountNumber) {
        String query = "DELETE FROM users WHERE accountNumber = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, accountNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
